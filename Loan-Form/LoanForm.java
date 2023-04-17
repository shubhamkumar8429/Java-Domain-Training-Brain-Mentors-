import java.util.Scanner;

interface Iform {
    String Sourcing(User user);

    void QDE(User user);

    int SIBILScore(User user);
}

class validateForm {
    public static boolean isValidName(String name) {
        return name.length() > 0;
    }

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public static boolean isValidCity(String city) {
        return city.length() > 0;
    }

    public static boolean isValidLoanType(int loanType) {
        return loanType == 0 || loanType == 1;
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidMobileNumber(long mobileNumber) {
        long n = mobileNumber;
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }

        return cnt == 10;
    }

    public static boolean isValidEmail(String email) {

        if (email.length() <= 3)
            return false;

        int n = email.length();

        boolean check = false;

        if (email.charAt(n - 3) == '.') {
            if (email.charAt(n - 2) == 'i' && email.charAt(n - 1) == 'n')
                check = true;
        } else if (email.charAt(n - 4) == '.') {
            if (n > 4) {
                if (email.charAt(n - 4) == '.' && email.charAt(n - 3) == 'c' && email.charAt(n - 2) == 'o'
                        && email.charAt(n - 1) == 'm')
                    check = true;
            }
        }

        if (check == false)
            return false;

        // now check for @

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (email.charAt(i) == '@')
                cnt++;
        }

        return cnt == 1;
    }

    public static boolean isValidDOB(String DOB) {
        return DOB.length() == 8;
    }

    public static boolean isValidAnnualIncome(double annualIncome) {
        return annualIncome > 0;
    }

}

class Form implements Iform {
    Scanner scanner = new Scanner(System.in);

    // @Override
    public String Sourcing(User user) {
        System.out.println("Enter your name");
        String name = scanner.nextLine();

        System.out.println("Enter your age");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your city");
        String city = scanner.nextLine();

        System.out.println("Please provide the loan type: \n0: Homeloan\n1:Autoloan");
        int loanType = scanner.nextInt();

        System.out.println("Enter the amount of loan");
        double amount = scanner.nextDouble();

        System.out.println("Enter your phone number");
        long mobileNumber = scanner.nextLong();
        scanner.nextLine();

        // if all is well then I will send an application id
        if (validateForm.isValidName(name) && validateForm.isValidAge(age) && validateForm.isValidAmount(amount)
                && validateForm.isValidCity(city) && validateForm.isValidLoanType(loanType)
                && validateForm.isValidMobileNumber(mobileNumber)) {

            user.setAge(age);
            user.setAmount(amount);
            user.setCity(city);
            user.setLoanType(loanType);
            user.setAmount(amount);
            user.setMobileNumber(mobileNumber);

            // now I will return an application id
            String applicationId = name + String.valueOf(age) + String.valueOf(mobileNumber);

            user.setApplicationStage(1);
            user.setApplicationId(applicationId);

            return applicationId;
        } else {
            System.out.println("\nPlease enter valid details\n");
        }

        return "";
    }

    // @Override
    public void QDE(User user) {
        String email;
        String DOB;

        System.out.println("Enter your email:");
        email = scanner.nextLine();

        System.out.println("Enter your date of birth");
        DOB = scanner.nextLine();

        System.out.println("Enter your annual income");
        double annualIncome = scanner.nextDouble();
        scanner.nextLine();

        if (validateForm.isValidEmail(email) && validateForm.isValidDOB(DOB)
                && validateForm.isValidAnnualIncome(annualIncome)) {
            // all details are valid
            user.setEmail(email);
            user.setDOB(DOB);
            user.setAnnualIncome(annualIncome);
            user.setApplicationStage(2);
        } else {
            System.out.println("\n\nPlease enter valid \n");
        }
    }

    public int SIBILScore(User user) {

        long blockedUsersMobile[] = { 1234567891, 1234567890, 2345678901L, 3456789012L };
        String blockedUsersEmail[] = { "kapur@gmail.com", "ravi@gmail.in", "ram@gmail.com", "shyam@gmail.in" };
        String blockedUserDOB[] = { "10102002", "10102001", "10122002", "11122013" };
        int n = blockedUserDOB.length;
        // now find out if this user exits;
        boolean flag = false;

        System.out.println(user.email);
        System.out.println(user.DOB);

        for (int i = 0; i < n; i++) {
            if (user.DOB.equals(blockedUserDOB[i]) && user.email.equals(blockedUsersEmail[i])
                    && user.mobileNumber == blockedUsersMobile[i]) {
                flag = true;
                break;
            }
        }

        user.setApplicationStage(3);

        if (flag == true) {
            return -1;
        }

        return 1;
    }

}

class User {
    String name;
    int age;
    String city;
    int loanType;
    double amount;
    long mobileNumber;
    String email;
    String DOB;
    double annualIncome;
    int applicationStage;
    String applicationId;

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setApplicationStage(int stage) {
        this.applicationStage = stage;
    }
}

abstract class Loan {
    public int loanPercent() {
        return 70;
    }

    public int durationYear() {
        return 10;
    }
}

class Homeloan extends Loan {
    @Override
    public int loanPercent() {
        return 70;
    }

    @Override
    public int durationYear() {
        return 30;
    }
}

class Autoloan extends Loan {
    @Override
    public int loanPercent() {
        return 60;
    }

    @Override
    public int durationYear() {
        return 10;
    }
}

public class LoanForm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User users[] = new User[10];
        int u = 0;

        int option = -1;

        while (option != 3) {
            System.out.println("\n\n1. New Application");
            System.out.println("2. Existing Application");
            System.out.println("3. Exit the program");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                // now I have to create a new user and start from begining
                User user = new User();

                // now go to the first step
                Form newform = new Form();

                String applicationId = newform.Sourcing(user);

                if (applicationId.length() == 0) {
                    System.out.println("Some error occured!! Please try again");
                    continue;
                }

                users[u++] = user;

                System.out.print("Your application id is:   ");
                System.out.println(applicationId);

                System.out.println("Please login via Existing application");
                System.out.println();

            } else if (option == 2) {

                System.out.println("Please provide your applicationId");
                String applicationId = scanner.nextLine();

                User user = null;
                for (int i = 0; i < u; i++) {
                    if (users[i].applicationId.equals(applicationId)) {
                        user = users[i];
                        break;
                    }
                }

                if (user == null) {
                    System.out.println("No such application found. Please try again");
                    continue;
                }

                if (user.applicationStage > 2) {

                }

                Form newform = new Form();

                while (user.applicationStage < 3) {

                    System.out.println("Would you like to continue to next step");
                    int curoption = scanner.nextInt();
                    if (curoption == 0)
                        break;

                    switch (user.applicationStage) {
                        case 1:
                            newform.QDE(user);
                            break;
                        case 2:
                            int value = newform.SIBILScore(user);
                            if (value < 0) {
                                System.out.println("We are sorry to say but we can't provide you loan");
                            } else {
                                System.out.println("Congratulations!! Your loan has been approved");

                                double LoanAmount = 0;
                                int LoanDuration = 0;

                                if (user.loanType == 0) {
                                    // means it is home loan
                                    Homeloan loan = new Homeloan();
                                    LoanAmount = (user.annualIncome * loan.loanPercent()) / 100.00;

                                    LoanDuration = loan.durationYear();
                                } else {
                                    // means it is auto loan

                                    Autoloan loan = new Autoloan();

                                    LoanAmount = (user.annualIncome * loan.loanPercent()) / 100.00;

                                    LoanDuration = loan.durationYear();
                                }

                                System.out.println("The amount of loan we can give you is :" + LoanAmount);
                                System.out.println("The loan is for " + LoanDuration + " years");
                            }
                            break;
                        default:
                            System.out.println("Your application process has been completed");
                            break;
                    }
                }

            } else if (option == 3) {
                System.out.println("Thank you");
                break;
            } else {
                System.out.println("Invalid input!! Please try again.");
                break;
            }
        }
    }
}