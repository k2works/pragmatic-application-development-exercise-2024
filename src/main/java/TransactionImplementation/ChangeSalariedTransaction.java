package TransactionImplementation;

import AbstractTransacions.ChangeClassificationTransaction;
import PayrollImplementation.SalariedClassification;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentSchedule;
import PayrollImplementation.MonthlySchedule;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private double itsSalary;
    private PayrollFactory itsPayrollFactory;

    public ChangeSalariedTransaction(int empId, double salary, PayrollFactory payrollFactory) {
        super(empId);
        itsSalary = salary;
        itsPayrollFactory = payrollFactory;
    }

    public PaymentSchedule GetSchedule() {
        return itsPayrollFactory.makeMonthlySchedule();
    }

    public PaymentClassification GetClassification() {
        return itsPayrollFactory.makeSalariedClassification(itsSalary);
    }
}
