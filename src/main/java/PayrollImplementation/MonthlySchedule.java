package PayrollImplementation;

import PayrollDomain.PaymentSchedule;

import java.util.Calendar;

/**
 * Created by k2works on 2017/04/06.
 */
public class MonthlySchedule implements PaymentSchedule {
    private boolean IsLastDayOfMonth(Calendar date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date.getTime());
        return (cal.getActualMaximum(Calendar.DATE) == cal.get(Calendar.DATE));
    }

    public boolean IsPayDate(Calendar payDate) {
        return IsLastDayOfMonth(payDate);
    }

    public Calendar GetPayPeriodStartDate(Calendar payDate) {
        Calendar payPeriodStartDate = Calendar.getInstance();
        payPeriodStartDate.setTime(payDate.getTime());
        payPeriodStartDate.set(Calendar.DATE,1);
        return payPeriodStartDate;
    }
}
