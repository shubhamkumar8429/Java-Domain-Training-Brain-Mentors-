import java.util.Scanner;

public class Login {
    User user;
    Scanner scanner;

    Login() {
        user = new User();
        scanner = new Scanner(System.in);
    }

    private boolean isValidCharacter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == ' ';
    }

    private boolean isValidPassword(String password) {
        return password.length() > 0;
    }

    private boolean isValidateUserName(String name) {
        if (name.length() == 0)
            return false;

        for (int i = 0; i < name.length(); i++) {
            if (!isValidCharacter(name.charAt(i)))
                return false;
        }

        return true;
    }

    private boolean isValidDetails(String name, String password) {
        return (name.equals(password)) && isValidateUserName(name) && isValidPassword(password);
    }

    private boolean ValidateLogin(String name, String password) {
        return isValidDetails(name, password);
    }

    private String inputUserName() {
        System.out.println("Please Enter your name");
        String name = scanner.nextLine();
        return name;
    }

    private String inputUserPassword() {
        System.out.println("Please Enter your password");
        String password = scanner.nextLine();
        return password;
    }

    public User performLogin() {
        String name = inputUserName();
        String password = inputUserPassword();

        if (ValidateLogin(name, password)) {
            user.setName(name);
            user.setPassword(password);
            return user;
        }

        System.out.println("\nPlease try again!!\n");
        return null;
    }
}
