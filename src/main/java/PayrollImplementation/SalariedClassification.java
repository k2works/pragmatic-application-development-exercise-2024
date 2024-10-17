package PayrollImplementation;

import PayrollDomain.Paycheck;
import PayrollDomain.PaymentClassification;

/**
 * Created by k2works on 2017/04/06.
 */
public class SalariedClassification implements PaymentClassification {
    private double itsSalary;

    public SalariedClassification(double salary) {
        itsSalary = salary;
    }

    public double GetSalary() {
        return itsSalary;
    }

    public double CalculatePay(Paycheck pc) {
        return itsSalary;
    }
}
