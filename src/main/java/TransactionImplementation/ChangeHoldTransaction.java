package TransactionImplementation;

import AbstractTransacions.ChangeMethodTransaction;
import PayrollImplementation.HoldMethod;
import PayrollDomain.PaymentMethod;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeHoldTransaction extends ChangeMethodTransaction {
    private PayrollFactory itsPayrollFactory;

    public ChangeHoldTransaction(int empId, PayrollFactory payrollFactory) {
        super(empId);
        itsPayrollFactory = payrollFactory;
    }

    public PaymentMethod GetMethod() {
        return itsPayrollFactory.makeHoldMethod();
    }
}
