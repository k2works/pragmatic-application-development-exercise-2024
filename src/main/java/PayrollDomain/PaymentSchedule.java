package PayrollDomain;

import java.util.Calendar;

/**
 * Created by k2works on 2017/04/06.
 */
public interface PaymentSchedule {
    boolean IsPayDate(Calendar payDate);

    Calendar GetPayPeriodStartDate(Calendar payDate);
}
