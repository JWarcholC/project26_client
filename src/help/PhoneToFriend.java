package help;
import control.QuestionController;

public class PhoneToFriend extends Helper {

    @Override
    public String getHelp(QuestionController controller) {
        String friendAnswer = controller.getQuestionNumber() < 5 ? "It must be: " :
                "I am not certain, but I think it is: ";

        if(controller.getQuestionNumber() > 5) { // if number is greater than 5, rand friend answer
            int chosenOne = getRand(1, 5);

            switch(chosenOne) {
                    case 1:
                        friendAnswer += controller.getAnswer1();
                        break;
                    case 2:
                        friendAnswer += controller.getAnswer2();
                        break;
                    case 3:
                        friendAnswer += controller.getAnswer3();
                        break;
                    case 4:
                        friendAnswer += controller.getAnswer4();
                        break;
            }
            return friendAnswer;
        }
        else { // in other case get correct
            return friendAnswer +  controller.getCorrectAnswer();
        }
    }
}
