package control;
import org.json.JSONException;
import org.json.JSONObject;
;import java.io.IOException;

public class QuestionController {
    public static final int QUESTIONS = 12;
    public static final String url = "http://127.0.0.1:8080/api/milion/question/";
    private int questionNumber = 1;

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;

    public QuestionController(){}

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void increaseCurrentQuestion() throws IOException {
        questionNumber++;
        setFields();
    }

    public void defaultQuestionNumber() throws IOException {
        questionNumber = 1;
        setFields();
    }

    public String getQuestion() {return question;}

    public String getAnswer1() {return answer1;}

    public String getAnswer2() {return answer2;}

    public String getAnswer3() {return answer3;}

    public String getAnswer4() {return answer4;}

    public String getCorrectAnswer() {return correctAnswer;}


    // create new JSON object from URL and then set actually value fields
    private void setFields() throws IOException {
       // JSONObject jsonObject = new JSONObject("{\"QUESTION\": \"ala\"; \"ANSWER1\": \"a\"; \"ANSWER2\": \"b\"; \"ANSWER3\": \"c\"; \"ANSWER4\": \"d\"; \"CORRECT_ANSWER\": \"d\"}");
       JSONObject jsonObject = JSONReader.readJsonFromUrl(url + questionNumber);
        question = jsonObject.getString("question");
        answer1 = jsonObject.getString("answer1");
        answer2 = jsonObject.getString("answer2");
        answer3 = jsonObject.getString("answer3");
        answer4 = jsonObject.getString("answer4");
        int correctAnswerNo = jsonObject.getInt("correctAnswer");
        correctAnswer = setCorrectAnswerField(correctAnswerNo);
    }

    private String setCorrectAnswerField(int no) {
        String ans = null;
        switch(no) {
            case 1:
                ans = answer1;
                break;
            case 2:
                ans = answer2;
                break;
            case 3:
                ans =answer3;
                break;
            case 4:
                ans = answer4;
                break;
        }
        return ans;
    }
}
