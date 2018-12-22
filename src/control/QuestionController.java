package control;

public class QuestionController {
    public static final int QUESTIONS = 12;
    private int currentQuestion;

    public QuestionController() {} //default constructor

    int getCurrentQuestion() {
        return currentQuestion;
    }

    void increaseCurrentQuestion() {
        currentQuestion++;
    }
}
