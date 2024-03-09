package TransactionImplementation;

import AbstractTransacions.ChangeEmployeeTransaction;
import PayrollDomain.Employee;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private String itsName;

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        itsName = name;
    }

    public void Change(Employee e) {
        e.SetName(itsName);
    }
}
