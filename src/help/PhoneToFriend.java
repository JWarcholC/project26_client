package help;
import control.QuestionController;

public class PhoneToFriend extends Helper {

    @Override
    public String getHelp(String qst, QuestionController controller) {
        String[] split = getSplit(qst);

        return split[getRand(MIN, MAX)];
    }
}
