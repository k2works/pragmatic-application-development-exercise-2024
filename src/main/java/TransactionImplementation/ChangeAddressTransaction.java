package TransactionImplementation;

import AbstractTransacions.ChangeEmployeeTransaction;
import PayrollDomain.Employee;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
    private String itsAddress;

    public ChangeAddressTransaction(int empId, String address) {
        super(empId);
        itsAddress = address;
    }

    public void Change(Employee e) {
        e.SetAddress(itsAddress);
    }
}
