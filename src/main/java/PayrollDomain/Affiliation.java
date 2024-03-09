package PayrollDomain;

import java.util.Calendar;

/**
 * Created by k2works on 2017/04/06.
 */
public interface Affiliation {
    double GetServiceCharge(Calendar date);

    double CalculateDeductions(Paycheck pc);
}
