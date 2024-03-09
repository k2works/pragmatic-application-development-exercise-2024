package PayrollImplementation;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import PayrollDomain.Affiliation;
import PayrollDomain.Paycheck;
import PayrollImplementation.ServiceCharge;
import PayrollUtil.Date;

/**
 * Created by k2works on 2017/04/06.
 */
public class UnionAffiliation implements Affiliation {
    private Map<Calendar, ServiceCharge> itsServiceCharges = new HashMap<Calendar, ServiceCharge>();
    private int itsMemberId;
    private double itsDues;

    public UnionAffiliation(double dues) {
        itsDues = dues;
    }

    public UnionAffiliation(int memberId, double dues) {
        itsMemberId = memberId;
        itsDues = dues;
    }

    public double GetServiceCharge(Calendar date) {
        if (itsServiceCharges.get(date) == null) {
            return 0;
        }
        return itsServiceCharges.get(date).GetAmount();
    }

    public double CalculateDeductions(Paycheck pc) {
        double totalServiceCharge = 0;
        double totalDues = 0;
        for (ServiceCharge sc : itsServiceCharges.values()) {
            if (Date.IsBetween(sc.GetDate(), pc.GetPayPeriodStartDate(),pc.GetPayPeriodEndDate())) {
                totalServiceCharge += sc.GetAmount();
            }
        }
        int fridays = NumberOfFridaysInPayPeriod(pc.GetPayPeriodStartDate(),pc.GetPayPeriodEndDate());
        totalDues = itsDues * fridays;
        return totalDues + totalServiceCharge;
    }

    private int NumberOfFridaysInPayPeriod(Calendar payPeriodStart, Calendar payPeriodEnd) {
        int fridays = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(payPeriodStart.getTime());
        while (cal.compareTo(payPeriodEnd) <= 0) {
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                fridays++;
            }
            cal.add(Calendar.DATE,1);
        }
        return fridays;
    }

    public void AddServiceCharge(Calendar date, double amount) {
        itsServiceCharges.put(date, new ServiceCharge(date, amount));
    }

    public int GetMemberId() {
        return itsMemberId;
    }

    public double GetDues() {
        return itsDues;
    }
}
