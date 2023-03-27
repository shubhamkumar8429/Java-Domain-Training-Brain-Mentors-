import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class Terms {
    ResourceBundle bundle;

    Terms() {
        Locale locale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("terms", locale);
    }

    public String getTerms() {
        return bundle.getString("terms");
    }
}
