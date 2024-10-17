package PayrollFactory;

import java.util.Calendar;

import PayrollDomain.Affiliation;
import PayrollDomain.Employee;
import PayrollDomain.Paycheck;
import PayrollDomain.PaymentClassification;
import PayrollDomain.PaymentMethod;
import PayrollDomain.PaymentSchedule;

/**
 * Created by k2works on 2017/04/10.
 */
public interface PayrollFactory {
    public PaymentSchedule makeBiweeklySchedule();

    public PaymentClassification makeCommissionedClassification(double salary, double commissionRate);

    public PaymentMethod makeDirectMethod(String bank, String account);

    public PaymentMethod makeHoldMethod();

    public PaymentClassification makeHourlyClassification(double hourlyRate);

    public PaymentMethod makeMailMethod(String address);

    public PaymentSchedule makeMonthlySchedule();

    public PaymentClassification makeSalariedClassification(double salary);

    public Affiliation makeUnionAffiliation(int memberId, double dues);

    public PaymentSchedule makeWeeklySchedule();

    public Affiliation makeNoAffiliation();

    public Employee makeEmployee(int empId, String name, String address);

    public Paycheck makePaycheck(Calendar getPayPeriodStartDate, Calendar payDate);
}

