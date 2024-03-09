package TransactionImplementation;

import java.util.Calendar;

import PayrollImplementation.CommissionedClassification;
import PayrollDatabase.GlobalDatabase;
import PayrollDomain.Employee;
import PayrollDomain.PaymentClassification;
import TransactionApplication.Transaction;

/**
 * Created by k2works on 2017/04/06.
 */
public class SalesReceiptTransaction implements Transaction {
    private Calendar itsSaleDate;
    private double itsAmount;
    private int itsEmpId;

    public SalesReceiptTransaction(Calendar saleDate, double amount, int empId) {
        itsSaleDate = saleDate;
        itsAmount = amount;
        itsEmpId = empId;
    }

    public void Execute() {
        Employee e = GlobalDatabase.payrollDB.GetEmployee(itsEmpId);
        if (e != null) {
            PaymentClassification pc = e.GetClassification();
            if (pc instanceof CommissionedClassification) {
                CommissionedClassification cc = (CommissionedClassification) pc;
                cc.AddReceipt(itsSaleDate, itsAmount);
            } else {
                System.err.println("Tried to add sales receipt to non-commissioned employee");
            }
        } else {
            System.err.println("No such employee.");
        }
    }
}
