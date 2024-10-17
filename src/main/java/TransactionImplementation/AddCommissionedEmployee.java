package TransactionImplementation;

import AbstractTransacions.AddEmployeeTransaction;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentSchedule;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/06.
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double itsSalary;
    private double itsCommissionRate;

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionRate, PayrollFactory payrollFactory) {
        super(empId, name, address, payrollFactory);
        itsSalary = salary;
        itsCommissionRate = commissionRate;
    }

    public PaymentClassification GetClassification() {
        return itsPayrollFactory.makeCommissionedClassification(itsSalary, itsCommissionRate);
    }

    public PaymentSchedule GetSchedule() {
        return itsPayrollFactory.makeBiweeklySchedule();
    }
}
