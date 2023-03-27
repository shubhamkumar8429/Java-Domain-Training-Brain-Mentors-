import java.util.Locale;
import java.util.ResourceBundle;

public class AnswerValidation {
    Locale locale;
    ResourceBundle bundle;

    AnswerValidation() {
        locale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("questions", locale);
    }

    private int getAnswer(int problemNumber) {
        String result = "Problem" + 4 + ".answer.option";
        return Integer.parseInt(bundle.getString(result));
    }

    public boolean checkAnswer(int problemNumber, int option) {
        return getAnswer(problemNumber) == option;
    }
}
