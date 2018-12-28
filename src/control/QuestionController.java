package control;
import org.json.JSONObject;

public class QuestionController {
    public static final int QUESTIONS = 12;
    public static final String url = "127.0.0.1:8080/api/milion/question/{";
    private static int questionNumber = 1;
    private JSONObject jsonObject;

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    //just for fun
    private String str1 = "Ala ma kota";
    private String str2 = "Ola ma psa";
    private int valid = 0 ;
    // TODO: new question = new QuestionController object!!
    public QuestionController() {
        jsonObject = new JSONObject("{\"Q\": \"ala\"; \"A1\": \"a\"; \"A2\": \"a\"; \"A3\": \"a\"; \"A4\": \"a\"; \"CORRECT_ANSWER\": \"a\"}");
        question = jsonObject.getString("Q");
        answer1 = jsonObject.getString("A1");
        answer2 = jsonObject.getString("A3");
        answer3 = jsonObject.getString("A2");
        answer4 = jsonObject.getString("A4");
        correctAnswer = jsonObject.getString("CORRECT_ANSWER");
    }

    public void increaseCurrentQuestion() {
        questionNumber++;
    }

    public void defaultQuestionNumber() {questionNumber = 1;}

    public String getQuestion() {return question;}

    //TODO: answer gettera
}
