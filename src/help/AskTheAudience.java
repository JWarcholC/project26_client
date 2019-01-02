package help;

import control.QuestionController;

import java.util.LinkedList;
import java.util.List;


public class AskTheAudience extends Helper {

    @Override
    public List<Integer> getHelp(QuestionController controller) {
        int percentOfAudience = 100;
        int correctPercent = getRand(50,percentOfAudience + 1);
        percentOfAudience -= correctPercent;
        List<Integer> percent = new LinkedList<>();
        if(!controller.getAnswer1().equals(controller.getCorrectAnswer())) {
            int ansPercent = getRand(0, percentOfAudience + 1);
            percentOfAudience -= ansPercent;
            percent.add(ansPercent);
        } else {
            percent.add(correctPercent);
        }
        if(!controller.getAnswer2().equals(controller.getCorrectAnswer())) {
            int ansPercent = getRand(0, percentOfAudience + 1);
            percentOfAudience -= ansPercent;
            percent.add(ansPercent);
        } else {
            percent.add(correctPercent);
        }
        if(!controller.getAnswer3().equals(controller.getCorrectAnswer())) {
            int ansPercent = getRand(0, percentOfAudience + 1);
            percentOfAudience -= ansPercent;
            percent.add(ansPercent);
        } else {
            percent.add(correctPercent);
        }
        if(!controller.getAnswer4().equals(controller.getCorrectAnswer())) {
            percent.add(percentOfAudience);
        } else {
            percent.add(correctPercent);
        }
        return percent;
    }
}
