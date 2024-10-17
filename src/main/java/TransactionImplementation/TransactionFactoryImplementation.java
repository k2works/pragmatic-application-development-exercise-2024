package TransactionImplementation;

import java.util.Calendar;

import PayrollFactory.PayrollFactory;
import TransactionApplication.Transaction;
import TransactionFactory.TransactionFactory;

/**
 * Created by k2works on 2017/04/10.
 */
public class TransactionFactoryImplementation implements TransactionFactory {
    private PayrollFactory itsPayrollFactory;

    public TransactionFactoryImplementation(PayrollFactory payrollFactory) {
        itsPayrollFactory = payrollFactory;
    }

    public Transaction makeAddCommissionedEmployee(int empId, String name, String address,
                                                   double salary, double commissionRate) {
        return new AddCommissionedEmployee(empId, name, address, salary, commissionRate, itsPayrollFactory);
    }

    public Transaction makeAddHourlyEmployee(int empId, String name, String address,
                                             double hourlyRate) {
        return new AddHourlyEmployee(empId, name, address, hourlyRate, itsPayrollFactory);
    }

    public Transaction makeAddSalariedEmployee(int empId, String name, String address, double salary) {
        return new AddSalariedEmployee(empId, name, address, salary, itsPayrollFactory);
    }

    public Transaction makeChangeAddressTransaction(int empId, String address) {
        return new ChangeAddressTransaction(empId, address);
    }

    public Transaction makeChangeCommissionedTransaction(int empId, double salary, double hourlyRate) {
        return new ChangeCommissionedTransaction(empId, salary, hourlyRate, itsPayrollFactory);
    }

    public Transaction makeChangeDirectTransaction(int empId, String bank, String account) {
        return new ChangeDirectTransaction(empId, bank, account, itsPayrollFactory);
    }

    public Transaction makeChangeHoldTransaction(int empId) {
        return new ChangeHoldTransaction(empId, itsPayrollFactory);
    }

    public Transaction makeChangeHourlyTransaction(int empId, double rate) {
        return new ChangeHourlyTransaction(empId, rate, itsPayrollFactory);
    }

    public Transaction makeChangeMailTransaction(int empId, String address) {
        return new ChangeMailTransaction(empId, address, itsPayrollFactory);
    }

    public Transaction makeChangeMemberTransaction(int empId, int memberId, double dues) {
        return new ChangeMemberTransaction(empId, memberId, dues, itsPayrollFactory);
    }

    public Transaction makeChangeNameTransaction(int empId, String name) {
        return new ChangeNameTransaction(empId, name);
    }

    public Transaction makeChangeSalariedTransaction(int empId, double salary) {
        return new ChangeSalariedTransaction(empId, salary, itsPayrollFactory);
    }

    public Transaction makeChangeUnaffiliatedTransaction(int empId) {
        return new ChangeUnaffiliatedTransaction(empId, itsPayrollFactory);
    }

    public Transaction makeDeleteEmployeeTransaction(int empId) {
        return new DeleteEmployeeTransaction(empId);
    }

    public Transaction makePaydayTransaction(Calendar payDate) {
        return new PaydayTransaction(payDate, itsPayrollFactory);
    }

    public Transaction makeSalesReceiptTransaction(Calendar saleDate, double amount, int empId) {
        return new SalesReceiptTransaction(saleDate, amount, empId);
    }

    public Transaction makeServiceChargeTransaction(int memberId, Calendar date, double amount) {
        return new ServiceChargeTransaction(memberId, date, amount);
    }

    public Transaction makeTimeCardTransaction(Calendar date, double hours, int empId) {
        return new TimeCardTransaction(date, hours, empId);
    }
}

