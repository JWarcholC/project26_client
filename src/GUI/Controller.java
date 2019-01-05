package GUI;

import control.QuestionController;
import help.AskTheAudience;
import help.Fifty;
import help.Helper;
import help.PhoneToFriend;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Optional;


public class Controller {

    private QuestionController questionController = new QuestionController();
    private Helper helper;
    private Alert alert; // to show dialog


    @FXML
    private Button start;

    @FXML
    private TextField question;

    @FXML
    private Button A;

    @FXML
    private Button B;

    @FXML
    private Button C;

    @FXML
    private Button D;

    @FXML
    private Button tel;

    @FXML
    private Button aud;

    @FXML
    private Button fifty;

    @FXML
    private Button end;

    @FXML
    private Label questionNumber;

    public Controller() throws Exception {}

    public void startGame(ActionEvent event) {
        setButtonsDisabled(false);
        setButtonsAndTextValue();
    }


    public void endGame(ActionEvent event) {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert = new Alert(Alert.AlertType.WARNING, "Are you sure to want to exit?",no, yes);
        alert.setTitle("Exit Dialog");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.orElse(no) == yes) { // short version of all if-else construction
            System.exit(0);
        }
    }

    public void AnswerA(ActionEvent event) throws IOException {
        checkQuestion(A);
    }

    public void AnswerB(ActionEvent event) throws IOException {
        checkQuestion(B);
    }

    public void AnswerC(ActionEvent event) throws IOException {
        checkQuestion(C);
    }

    public void AnswerD(ActionEvent event) throws IOException {
        checkQuestion(D);
    }

    public void AudButton(ActionEvent event) {
        aud.setDisable(true);
        helper = new AskTheAudience();
        LinkedList<Integer> percent = (LinkedList<Integer>)helper.getHelp(questionController);
        AudienceBarChart chart = new AudienceBarChart();
        chart.display(percent);
    }

    public void TeleButton(ActionEvent event) {
        tel.setDisable(true);
        helper = new PhoneToFriend();
        String friendAnswer = (String)helper.getHelp(questionController);
        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alert = new Alert(Alert.AlertType.NONE, friendAnswer, ok);
        alert.setTitle("Telephone Help");
        Optional<ButtonType> result = alert.showAndWait();
    }

    public void FiftyButton(ActionEvent event) {
        fifty.setDisable(true);
        helper = new Fifty();
        LinkedList<Integer> wrong = (LinkedList<Integer>)helper.getHelp(questionController);
        for (int i : wrong) {
            switch(i) {
                case 1:
                    A.setDisable(true);
                    break;
                case 2:
                    B.setDisable(true);
                    break;
                case 3:
                    C.setDisable(true);
                    break;
                case 4:
                    D.setDisable(true);
                    break;
            }
        }
    }

    private void winnerController() {
        if(questionController.getQuestionNumber() > QuestionController.QUESTIONS) {
            ButtonType endGame = new ButtonType("Finish", ButtonBar.ButtonData.FINISH);
            alert = new Alert(Alert.AlertType.INFORMATION, "You win $1 000 000!!! :D ", endGame);
            alert.setTitle("\t\tWINNER");
            Optional<ButtonType> result = alert.showAndWait();

            setDefaultsButtonsAndTextValue(); // clear text fields
            setButtonsDisabled(true); // dafault buttons and textfield behaviour
            questionController.defaultQuestionNumber(); // change question' number to default (=1)
        } else {
            questionNumber.setText(questionController.getQuestionNumber() + "/12");
        }
    }

    private void setButtonsDisabled(boolean value) {
        A.setDisable(value);
        B.setDisable(value);
        C.setDisable(value);
        D.setDisable(value);
        tel.setDisable(value);
        fifty.setDisable(value);
        aud.setDisable(value);
        question.setDisable(value);
        start.setDisable(!value);
    }

    private void setButtonsAndTextValue() {
        question.setText(questionController.getQuestion());
        A.setText(questionController.getAnswer1());
        B.setText(questionController.getAnswer2());
        C.setText(questionController.getAnswer3());
        D.setText(questionController.getAnswer4());
        questionNumber.setText(questionController.getQuestionNumber() + "/12");
    }

    private void setDefaultsButtonsAndTextValue() {
        question.setText("");
        A.setText("");
        B.setText("");
        C.setText("");
        D.setText("");
        questionNumber.setText("");
    }

    private void checkQuestion(Button button) throws IOException { // check if answer is correct

        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        if(button.getText().equals(questionController.getCorrectAnswer())) {
            alert = new Alert(Alert.AlertType.CONFIRMATION, "Good answer is: " + questionController.getCorrectAnswer(), ok);
            alert.setTitle("Congratulations!");
            Optional<ButtonType> result = alert.showAndWait();

            questionController.increaseCurrentQuestion(); //increase game level
            winnerController(); //check if you win
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Good answer is: " + questionController.getCorrectAnswer() + "\nYou lose!", ok);
            alert.setTitle("Looooser!");
            Optional<ButtonType> result = alert.showAndWait();

            setDefaultsButtonsAndTextValue(); // clear text fields
            setButtonsDisabled(true); // dafault buttons and textfield behaviour
            questionController.defaultQuestionNumber(); // change question' number to default (=1)
        }
    }

}
