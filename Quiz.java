import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Quiz {
    static Scanner scanner = new Scanner(System.in);

    public static void clrscr() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void clearScreen() {
        clrscr();
    }

    public static void ShowTerms() {
        Terms terms = new Terms();
        System.out.println("The terms and conditions are:");
        System.out.println(terms.getTerms());
    }

    public static int[] AskQuestions(ProblemStatement problem, int len) {
        int[] UserAnswers = new int[len];

        for (int i = 1; i <= len; i++) {
            System.out.println("Q" + i + ": " + problem.getProblemStatement(i));
            System.out.println();
            System.out.println("1: " + problem.getOption(i, 1));
            System.out.println("2: " + problem.getOption(i, 2));
            System.out.println("3: " + problem.getOption(i, 3));
            System.out.println("4: " + problem.getOption(i, 4));

            int selected = scanner.nextInt();
            UserAnswers[i - 1] = selected;

            System.out.println();
        }
        return UserAnswers;
    }

    public static void ShowResult(ProblemStatement problem, int len, int[] UserAnswers) {
        for (int i = 0; i < 50; i++) {
            System.out.print('-');
        }

        System.out.print(" Result Card ");
        for (int i = 0; i < 50; i++) {
            System.out.print('-');
        }

        System.out.println();
        System.out.println();

        int total = 0;

        for (int i = 0; i < len; i++) {
            System.out.println("Q" + (i + 1) + ": " + problem.getProblemStatement(i + 1));
            System.out.println();
            System.out.println("Your Answer: " + problem.getOption(i + 1, UserAnswers[i]));
            System.out.println("Correct Answer: " + problem.getOption(i + 1, problem.getAnswer(i + 1)));

            if (problem.getAnswer(i + 1) == UserAnswers[i]) {
                System.out.println("Correct");
                total += 5;
            } else
                System.err.println("Wrong");

            System.out.println();
        }

        System.out.println("Your total score is : " + total);
    }

    public static void SayThankYou() {
        System.out.println("Thank you for giving the contest");
    }

    public static void main(String[] args) {

        clearScreen();

        Login login = new Login();
        User user = null;

        int loginCount = 0;
        while (loginCount < 3) {
            user = login.performLogin();
            if (user != null)
                break;
            loginCount++;
        }

        if (user == null) {
            System.out.println("Login limit exceeded! Please restart the program and come back again.");
            return;
        }

        clearScreen();
        // now clear the screen
        // and show the terms and conditions
        ShowTerms();

        System.out.println("Do you accept the terms and conditions y/n:");
        char opt = scanner.next().charAt(0);

        if (opt != 'y') {
            System.out.println("Thank you");
            return;
        }

        System.out.println("Loading the game....");

        clearScreen();

        // create bundle to get all the questions
        ProblemStatement problem = new ProblemStatement();
        int len = problem.NumberOfQuestion();
        int[] UserAnswers = AskQuestions(problem, len);

        clearScreen();
        // now show the result
        ShowResult(problem, len, UserAnswers);
        SayThankYou();
    }
}
