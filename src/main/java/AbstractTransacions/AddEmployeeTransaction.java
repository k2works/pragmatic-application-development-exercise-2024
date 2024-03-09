package AbstractTransacions;

import PayrollImplementation.HoldMethod;
import PayrollDatabase.GlobalDatabase;
import PayrollDomain.Employee;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentMethod;
import PayrollDomain.PaymentSchedule;
import PayrollFactory.PayrollFactory;
import TransactionApplication.Transaction;

/**
 * Created by k2works on 2017/04/06.
 */
public abstract class AddEmployeeTransaction implements Transaction {
    private int itsEmpId;
    private String itsName;
    private String itsAddress;
    protected PayrollFactory itsPayrollFactory;

    public AddEmployeeTransaction(int empId, String name, String address, PayrollFactory payrollFactory) {
        itsEmpId = empId;
        itsName = name;
        itsAddress = address;
        itsPayrollFactory = payrollFactory;
    }

    public void Execute() {
        PaymentClassification pc = GetClassification();
        PaymentSchedule ps = GetSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpId, itsName, itsAddress);
        e.SetClassification(pc);
        e.SetSchedule(ps);
        e.SetMethod(pm);
        GlobalDatabase.payrollDB.AddEmployee(itsEmpId, e);
    }

    public abstract PaymentSchedule GetSchedule();

    public abstract PaymentClassification GetClassification();
}
