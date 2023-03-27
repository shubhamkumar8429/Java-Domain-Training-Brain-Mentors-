
import java.util.Locale;
import java.util.ResourceBundle;

public class ProblemStatement {

    Locale locale;
    ResourceBundle bundle;

    ProblemStatement() {
        locale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("questions", locale);
    }

    public String getProblemStatement(int index) {
        String problem = "Problem" + index + ".statement";
        return bundle.getString(problem);
    }

    public String getOption(int problemNumber, int optionNumber) {
        String option = "Problem" + problemNumber + "." + optionNumber + ".option";
        return bundle.getString(option);
    }

    public int NumberOfQuestion() {
        return Integer.parseInt(bundle.getString("numberOfQuestions"));
    }

    public int getAnswer(int problemNumber) {
        String str = "Problem" + problemNumber + ".answer.option";
        return Integer.parseInt(bundle.getString(str));
    }

}
