package PayrollDatabaseImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PayrollDatabase.PayrollDatabase;
import PayrollDomain.Employee;

/**
 * Created by k2works on 2017/04/10.
 */
public class PayrollDatabaseImplementation implements PayrollDatabase {
    private static Map<Integer, Employee> itsEmployees = new HashMap<Integer, Employee>();
    private static Map<Integer, Employee> itsUnionMembers = new HashMap<Integer, Employee>();

    public void AddEmployee(int empId, Employee e) {
        itsEmployees.put(empId, e);
    }

    public Employee GetEmployee(int empId) {
        return itsEmployees.get(empId);
    }

    public void Clear() {
        itsEmployees.clear();
        itsUnionMembers.clear();
    }

    public void DeleteEmployee(int empId) {
        itsEmployees.remove(empId);
    }

    public void AddUnionMember(int memberId, Employee e) {
        itsUnionMembers.put(memberId, e);
    }

    public Employee GetUnionMember(int memberId) {
        return itsUnionMembers.get(memberId);
    }

    public void RemoveUnionMember(int memberId) {
        itsUnionMembers.remove(memberId);
    }

    public List<Integer> GetAllEmployeeIds() {
        return new ArrayList<Integer>(itsEmployees.keySet());
    }
}