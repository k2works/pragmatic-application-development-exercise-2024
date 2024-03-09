package TransactionImplementation;

import AbstractTransacions.ChangeClassificationTransaction;
import PayrollImplementation.HourlyClassification;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentSchedule;
import PayrollImplementation.WeeklySchedule;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private double itsRate;
    private PayrollFactory itsPayrollFactory;

    public ChangeHourlyTransaction(int empId, double rate, PayrollFactory payrollFactory) {
        super(empId);
        itsRate = rate;
        itsPayrollFactory = payrollFactory;
    }


    public PaymentSchedule GetSchedule() {
        return itsPayrollFactory.makeWeeklySchedule();
    }

    public PaymentClassification GetClassification() {
        return itsPayrollFactory.makeHourlyClassification(itsRate);
    }
}
