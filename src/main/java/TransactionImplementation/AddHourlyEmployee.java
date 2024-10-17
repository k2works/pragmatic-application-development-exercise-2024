package TransactionImplementation;

import AbstractTransacions.AddEmployeeTransaction;
import PayrollImplementation.HourlyClassification;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentSchedule;
import PayrollFactory.PayrollFactory;
import PayrollImplementation.WeeklySchedule;

/**
 * Created by k2works on 2017/04/06.
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double itsHourlyRate;

    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate, PayrollFactory payrollFactory) {
        super(empId, name, address, payrollFactory);
        itsHourlyRate = hourlyRate;
    }

    public PaymentClassification GetClassification() {
        return itsPayrollFactory.makeHourlyClassification(itsHourlyRate);
    }

    public PaymentSchedule GetSchedule() {
        return itsPayrollFactory.makeWeeklySchedule();
    }
}
