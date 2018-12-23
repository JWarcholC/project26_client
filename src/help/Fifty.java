package help;

import control.QuestionController;

public class Fifty extends Helper {

    @Override
    public String getHelp(String qst, QuestionController controller) {
        String[] split = getSplit(qst);
        int i;
        for(i = 2; i < 6; i++) {
            if(split[i].equals(split[6])) {
                break;
            }
        }

        int rand = getRand(MIN, MAX);
        if(rand == i) {
            if( rand == 5) {
                rand--;
            } else {
                rand++;
            }
        }

        return split[i] + split[rand];
    }
}
