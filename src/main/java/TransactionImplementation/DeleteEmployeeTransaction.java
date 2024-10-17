package TransactionImplementation;

import PayrollDatabase.GlobalDatabase;
import TransactionApplication.Transaction;

/**
 * Created by k2works on 2017/04/06.
 */
public class DeleteEmployeeTransaction implements Transaction {
    private int itsEmpId;
    public DeleteEmployeeTransaction(int empId) {
        itsEmpId = empId;
    }

    public void Execute() {
        GlobalDatabase.payrollDB.DeleteEmployee(itsEmpId);
    }
}
