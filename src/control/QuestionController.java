package control;
import org.json.JSONException;
import org.json.JSONObject;
;import java.io.IOException;

public class QuestionController {
    public static final int QUESTIONS = 12;
    public static final String url = "127.0.0.1:8080/api/milion/question/";
    private static int questionNumber = 1;

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;

    public QuestionController() throws Exception {
        setFields();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void increaseCurrentQuestion() throws IOException {
        questionNumber++;
        setFields();
    }

    public void defaultQuestionNumber() {questionNumber = 1;}

    public String getQuestion() {return question;}

    public String getAnswer1() {return answer1;}

    public String getAnswer2() {return answer2;}

    public String getAnswer3() {return answer3;}

    public String getAnswer4() {return answer4;}

    public String getCorrectAnswer() {return correctAnswer;}


    // create new JSON object from URL and then set actually value fields
    private void setFields() throws IOException {
        JSONObject jsonObject = new JSONObject("{\"QUESTION\": \"ala\"; \"ANSWER1\": \"a\"; \"ANSWER2\": \"b\"; \"ANSWER3\": \"c\"; \"ANSWER4\": \"d\"; \"CORRECT_ANSWER\": \"d\"}");
      //  JSONObject jsonObject = JSONReader.readJsonFromUrl(url + questionNumber);
        question = jsonObject.getString("QUESTION");
        answer1 = jsonObject.getString("ANSWER1");
        answer2 = jsonObject.getString("ANSWER3");
        answer3 = jsonObject.getString("ANSWER2");
        answer4 = jsonObject.getString("ANSWER4");
        correctAnswer = jsonObject.getString("CORRECT_ANSWER");
    }
}
