package PayrollImplementation;

import java.util.Calendar;

/**
 * Created by k2works on 2017/04/06.
 */
public class SalesReceipt {
    private Calendar itsSaleDate;
    private double itsAmount;

    public SalesReceipt(Calendar saleDate, double amount) {
        itsSaleDate = saleDate;
        itsAmount = amount;
    }

    public Calendar GetSaleDate() {
        return itsSaleDate;
    }

    public double GetAmount() {
        return itsAmount;
    }
}
