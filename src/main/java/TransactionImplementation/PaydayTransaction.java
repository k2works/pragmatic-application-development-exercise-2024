package TransactionImplementation;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PayrollDatabase.GlobalDatabase;
import PayrollDomain.Employee;
import PayrollDomain.Paycheck;
import TransactionApplication.Transaction;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/07.
 */
public class PaydayTransaction implements Transaction {
    private Calendar itsPayDate;
    private Map<Integer, Paycheck> itsPaychecks = new HashMap<Integer, Paycheck>();
    private PayrollFactory itsPayrollFactory;

    public PaydayTransaction(Calendar payDate, PayrollFactory payrollFactory) {
        itsPayDate = payDate;
        itsPayrollFactory = payrollFactory;
    }

    public void Execute() {
        List<Integer> empIds = GlobalDatabase.payrollDB.GetAllEmployeeIds();
        for(int empId : empIds) {
            Employee e = GlobalDatabase.payrollDB.GetEmployee(empId);
            if(e.IsPayDate(itsPayDate)) {
                Paycheck pc = itsPayrollFactory.makePaycheck(e.GetPayPeriodStartDate(itsPayDate),itsPayDate);
                itsPaychecks.put(empId, pc);
                e.Payday(pc);
            }
        }
    }

    public Paycheck GetPaycheck(int empId) {
        return itsPaychecks.get(empId);
    }
}
