package PayrollImplementation;

import java.util.Calendar;

/**
 * Created by k2works on 2017/04/06.
 */
public class ServiceCharge {
    private Calendar itsDate;
    private double itsAmount;

    public ServiceCharge(Calendar date, double amount) {
        itsDate = date;
        itsAmount = amount;
    }

    public Calendar GetDate() {
        return itsDate;
    }

    public double GetAmount() {
        return itsAmount;
    }
}
