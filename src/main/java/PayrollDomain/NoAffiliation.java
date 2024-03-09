package PayrollDomain;

import java.util.Calendar;

/**
 * Created by k2works on 2017/04/07.
 */
public class NoAffiliation implements Affiliation {
    public double GetServiceCharge(Calendar date) {
        return 0;
    }

    public double CalculateDeductions(Paycheck pc) {
        return 0;
    }
}
