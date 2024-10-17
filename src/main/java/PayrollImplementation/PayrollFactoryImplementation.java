package PayrollImplementation;

import java.util.Calendar;

import PayrollDomain.Affiliation;
import PayrollDomain.Employee;
import PayrollDomain.NoAffiliation;
import PayrollDomain.Paycheck;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentMethod;
import PayrollDomain.PaymentSchedule;
import PayrollFactory.PayrollFactory;

/**
 * Created by k2works on 2017/04/10.
 */
public class PayrollFactoryImplementation implements PayrollFactory {
    public PaymentSchedule makeBiweeklySchedule() {
        return new BiweeklySchedule();
    }

    public PaymentClassification makeCommissionedClassification(double salary, double commissionRate) {
        return new CommissionedClassification(salary, commissionRate);
    }

    public PaymentMethod makeDirectMethod(String bank, String account) {
        return new DirectMethod(bank, account);
    }

    public PaymentMethod makeHoldMethod() {
        return new HoldMethod();
    }

    public PaymentClassification makeHourlyClassification(double hourlyRate) {
        return new HourlyClassification(hourlyRate);
    }

    public PaymentMethod makeMailMethod(String address) {
        return new MailMethod(address);
    }

    public PaymentSchedule makeMonthlySchedule() {
        return new MonthlySchedule();
    }

    public PaymentClassification makeSalariedClassification(double salary) {
        return new SalariedClassification(salary);
    }

    public SalesReceipt makeSalesReceipt(Calendar saleDate, double amount) {
        return new SalesReceipt(saleDate, amount);
    }

    public Affiliation makeUnionAffiliation(int memberId, double dues) {
        return new UnionAffiliation(memberId, dues);
    }

    public PaymentSchedule makeWeeklySchedule() {
        return new WeeklySchedule();
    }

    public Affiliation makeNoAffiliation() {
        return new NoAffiliation();
    }

    public Employee makeEmployee(int empId, String name, String address) {
        return new Employee(empId, name, address);
    }

    public Paycheck makePaycheck(Calendar payPeriodStartDate, Calendar payDate) {
        return new PaycheckImplementation(payPeriodStartDate, payDate);
    }
}
