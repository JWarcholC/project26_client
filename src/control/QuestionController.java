package control;

public class QuestionController {
    public static final int QUESTIONS = 12;
    private int currentQuestion;

    public QuestionController() {} //default constructor

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void increaseCurrentQuestion() {
        currentQuestion++;
    }
}
