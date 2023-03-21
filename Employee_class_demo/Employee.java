import java.util.Locale;
import java.util.ResourceBundle;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private double baseSalary;
    private String name;
    private String joinDate;
    private int id;
    private double netSalary;
    private Locale locale;

    private void updateNetSalary() {
        NetSalary netSalary = new NetSalary();
        this.netSalary = netSalary.ComputeNetSalary(baseSalary);
    }

    private void setJoiningDate() {
        ResourceBundle bundle = ResourceBundle.getBundle("Allowance", Locale.US);
        String DateFormate = bundle.getString("DateFormate");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DateFormate);
        LocalDateTime now = LocalDateTime.now();
        this.joinDate = dtf.format(now);
    }

    Employee(int id, String name, double salary, Locale locale) {
        this.id = id;
        this.name = name;
        this.baseSalary = salary;
        this.locale = locale;
        updateNetSalary();
        setJoiningDate();
    }

    public String getName() {
        return name;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double salary) {
        this.baseSalary = salary;
        updateNetSalary();
    }

    public void printDetails() {

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);

        System.out.println(bundle.getString("Id") + ": " + id);
        System.out.println(bundle.getString("Name") + ": " + name);
        System.out.println(bundle.getString("JoiningDate") + ": " + joinDate);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(this.locale);
        String currency = formatter.format(this.netSalary);
        System.out.println(bundle.getString("netSalary") + ": " + currency);
    }
}
