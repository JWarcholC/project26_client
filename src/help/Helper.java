package help;

import control.QuestionController;
import java.util.concurrent.ThreadLocalRandom;

abstract public class Helper {
    public static final int MIN = 2;
    public static final int MAX = 5;

    abstract public String getHelp(String qst, QuestionController controller);

    protected String[] getSplit(String qst) {
        return qst.split(";");
    }

    protected int getRand(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
