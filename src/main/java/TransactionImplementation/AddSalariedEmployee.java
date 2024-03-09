package TransactionImplementation;

import AbstractTransacions.AddEmployeeTransaction;
import PayrollImplementation.SalariedClassification;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentSchedule;
import PayrollFactory.PayrollFactory;
import PayrollImplementation.MonthlySchedule;

/**
 * Created by k2works on 2017/04/06.
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double itsSalary;

    public AddSalariedEmployee(int empId, String name, String address, double salary, PayrollFactory payrollFactory) {
        super(empId, name, address, payrollFactory);
        itsSalary = salary;
    }

    public PaymentClassification GetClassification() {
        return itsPayrollFactory.makeSalariedClassification(itsSalary);
    }

    public PaymentSchedule GetSchedule() {
        return itsPayrollFactory.makeMonthlySchedule();
    }
}
