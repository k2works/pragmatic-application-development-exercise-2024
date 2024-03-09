package AbstractTransacions;

import PayrollDomain.Affiliation;
import PayrollDomain.Employee;

/**
 * Created by k2works on 2017/04/07.
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    public void Change(Employee e) {
        RecordMembership(e);
        e.SetAffiliation(GetAffiliation());
    }

    public abstract void RecordMembership(Employee e);

    public abstract Affiliation GetAffiliation();
}
