package AbstractTransacions;

import PayrollDomain.Employee;
import PayrollDomain.PaymentMethod;

/**
 * Created by k2works on 2017/04/07.
 */
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    public void Change(Employee e) {
        e.SetMethod(GetMethod());
    }

    public abstract PaymentMethod GetMethod();
}
