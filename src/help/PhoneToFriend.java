package help;
import control.QuestionController;

public class PhoneToFriend extends Helper {

    @Override
    public String getHelp(QuestionController controller) {
        if(controller.getQuestionNumber() > 5) {
            int chosenOne = getRand(1, 5);
            String friendAnswer ="";
            switch(chosenOne) {
                    case 1:
                        friendAnswer = controller.getAnswer1();
                        break;
                    case 2:
                        friendAnswer = controller.getAnswer2();
                        break;
                    case 3:
                        friendAnswer = controller.getAnswer3();
                        break;
                    case 4:
                        friendAnswer = controller.getAnswer4();
                        break;
            }
            return friendAnswer;
        }
        else {
            return controller.getCorrectAnswer();
        }
    }
}
