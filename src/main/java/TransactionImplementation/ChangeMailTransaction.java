package TransactionImplementation;

import AbstractTransacions.ChangeMethodTransaction;
import PayrollImplementation.MailMethod;
import PayrollDomain.PaymentMethod;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/07.
 */
public class ChangeMailTransaction extends ChangeMethodTransaction {
    private String itsAddress;
    private PayrollFactory itsPayrollFactory;

    public ChangeMailTransaction(int empId, String address, PayrollFactory payrollFactory) {
        super(empId);
        itsAddress = address;
        itsPayrollFactory = payrollFactory;
    }

    public PaymentMethod GetMethod() {
        return itsPayrollFactory.makeMailMethod(itsAddress);
    }
}
