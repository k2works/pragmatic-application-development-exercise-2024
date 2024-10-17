package TransactionFactory;

import java.util.Calendar;

import TransactionApplication.Transaction;

/**
 * Created by k2works on 2017/04/10.
 */
public interface TransactionFactory {
    public Transaction makeAddCommissionedEmployee(int empId, String name, String address,
                                                   double salary, double commissionRate);

    public Transaction makeAddHourlyEmployee(int empId, String name, String address,
                                             double hourlyRate);

    public Transaction makeAddSalariedEmployee(int empId, String name, String address, double salary);

    public Transaction makeChangeAddressTransaction(int empId, String address);

    public Transaction makeChangeCommissionedTransaction(int empId, double salary, double hourlyRate);

    public Transaction makeChangeDirectTransaction(int empId, String bank, String account);

    public Transaction makeChangeHoldTransaction(int empId);

    public Transaction makeChangeHourlyTransaction(int empId, double rate);

    public Transaction makeChangeMailTransaction(int empId, String address);

    public Transaction makeChangeMemberTransaction(int empId, int memberId, double dues);

    public Transaction makeChangeNameTransaction(int empId, String name);

    public Transaction makeChangeSalariedTransaction(int empId, double salary);

    public Transaction makeChangeUnaffiliatedTransaction(int empId);

    public Transaction makeDeleteEmployeeTransaction(int empId);

    public Transaction makePaydayTransaction(Calendar payDate);

    public Transaction makeSalesReceiptTransaction(Calendar saleDate, double amount, int empId);

    public Transaction makeServiceChargeTransaction(int memberId, Calendar date, double amount);

    public Transaction makeTimeCardTransaction(Calendar date, double hours, int empId);
}
