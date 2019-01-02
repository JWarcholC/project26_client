package help;

import control.QuestionController;
import java.util.concurrent.ThreadLocalRandom;

abstract public class Helper {
    public static final int MIN = 1;
    public static final int MAX = 4;

    abstract public Object getHelp(QuestionController controller);


    protected int getRand(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
