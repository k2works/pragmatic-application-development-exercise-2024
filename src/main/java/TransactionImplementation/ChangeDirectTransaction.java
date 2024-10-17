package TransactionImplementation;

import AbstractTransacions.ChangeMethodTransaction;
import PayrollImplementation.DirectMethod;
import PayrollDomain.PaymentMethod;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeDirectTransaction extends ChangeMethodTransaction {
    private String itsBank;
    private String itsAccount;
    private PayrollFactory itsPayrollFactory;

    public ChangeDirectTransaction(int empId, String bank, String account, PayrollFactory payrollFactory) {
        super(empId);
        itsBank = bank;
        itsAccount = account;
        itsPayrollFactory = payrollFactory;
    }

    public PaymentMethod GetMethod() {
        return itsPayrollFactory.makeDirectMethod(itsBank, itsAccount);
    }
}
