package help;

import control.QuestionController;

import java.util.LinkedList;
import java.util.List;


public class Fifty extends Helper {

    @Override
    public List<Integer> getHelp(QuestionController controller) {
        List<Integer> wrong = new LinkedList<>();
        if(!controller.getAnswer1().equals(controller.getCorrectAnswer())) {
            wrong.add(1);
        }
        if(!controller.getAnswer2().equals(controller.getCorrectAnswer())) {
            wrong.add(2);
        }
        if(!controller.getAnswer3().equals(controller.getCorrectAnswer())) {
            wrong.add(3);
        }
        if(!controller.getAnswer4().equals(controller.getCorrectAnswer())) {
            wrong.add(4);
        }
        int chosenOne = getRand(0, 3);
        wrong.remove(chosenOne);

        return wrong;
    }
}
