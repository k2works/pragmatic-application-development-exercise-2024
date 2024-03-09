package PayrollImplementation;

import java.util.Calendar;
import java.util.GregorianCalendar;

import PayrollDomain.PaymentSchedule;

/**
 * Created by k2works on 2017/04/06.
 */
public class BiweeklySchedule implements PaymentSchedule {
    private final Calendar FIRST_PAYBALE_FRIDAY = new GregorianCalendar(2001, Calendar.NOVEMBER, 9);

    public boolean IsPayDate(Calendar payDate) {
        Calendar cal = Calendar.getInstance();
        if ((payDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)) {
            cal.setTime(FIRST_PAYBALE_FRIDAY.getTime());
            while (cal.compareTo(payDate) <= 0) {
                if (cal.equals(payDate)) {
                    return true;
                }
                cal.add(Calendar.DATE, 14);
            }
        }
        return false;
    }

    public Calendar GetPayPeriodStartDate(Calendar payDate) {
        Calendar payPeriodStartDate = Calendar.getInstance();
        payPeriodStartDate.setTime(payDate.getTime());
        payPeriodStartDate.add(Calendar.DATE, -13);
        return payPeriodStartDate;
    }
}