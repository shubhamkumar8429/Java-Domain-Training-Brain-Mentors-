import java.util.Locale;
import java.util.ResourceBundle;

public class NetSalary {
    public double ComputeNetSalary(Double salary) {
        double netSalary = salary;
        ResourceBundle bundle = ResourceBundle.getBundle("Allowance", Locale.US);

        String House_Rent_Allowance = bundle.getString("House_Rent_Allowance");
        String Dearness_Allowance = bundle.getString("Dearness_Allowance");
        String Entertainment_Allowance = bundle.getString("Entertainment_Allowance");
        String Medical_Allowance = bundle.getString("Medical_Allowance");

        House_Rent_Allowance = House_Rent_Allowance.substring(0, House_Rent_Allowance.length() - 1);
        Dearness_Allowance = House_Rent_Allowance.substring(0, Dearness_Allowance.length() - 1);
        Entertainment_Allowance = House_Rent_Allowance.substring(0, Entertainment_Allowance.length() - 1);
        Medical_Allowance = House_Rent_Allowance.substring(0, Medical_Allowance.length() - 1);

        int House_Rent_Allowance_Percent = Integer.parseInt(House_Rent_Allowance);
        int Dearness_Allowance_Percent = Integer.parseInt(Dearness_Allowance);
        int Entertainment_Allowance_Percent = Integer.parseInt(Entertainment_Allowance);
        int Medical_Allowance_Percent = Integer.parseInt(Medical_Allowance);

        netSalary += (salary * House_Rent_Allowance_Percent) / 100.000;
        netSalary += (salary * Dearness_Allowance_Percent) / 100.000;
        netSalary += (salary * Entertainment_Allowance_Percent) / 100.000;
        netSalary += (salary * Medical_Allowance_Percent) / 100.000;

        if (netSalary >= 7000000) {
            netSalary -= (netSalary * 10.00) / 100.00;
        } else if (netSalary >= 1000000) {
            netSalary -= (netSalary * 30.00) / 100.00;
        }
        return netSalary;
    }

}
