package TransactionImplementation;

import AbstractTransacions.ChangeClassificationTransaction;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentSchedule;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
    private double itsSalary;
    private double itsHourlyRate;
    private PayrollFactory itsPayrollFactory;

    public ChangeCommissionedTransaction(int empId, double salary, double hourlyRate, PayrollFactory payrollFactory) {
        super(empId);
        itsSalary = salary;
        itsHourlyRate = hourlyRate;
        itsPayrollFactory = payrollFactory;
    }

    public PaymentSchedule GetSchedule() {
        return itsPayrollFactory.makeBiweeklySchedule();
    }

    public PaymentClassification GetClassification() {
        return itsPayrollFactory.makeCommissionedClassification(itsSalary, itsHourlyRate);
    }
}
