import java.util.Calendar;
import java.util.GregorianCalendar;

import Application.Application;
import PayrollImplementation.HourlyClassification;
import PayrollImplementation.TimeCard;
import PayrollApplication.PayrollApplication;
import PayrollDatabase.GlobalDatabase;
import PayrollDatabaseImplementation.PayrollDatabaseImplementation;
import PayrollDomain.Employee;
import PayrollDomain.PaymentClassification;

/**
 * Created by k2works on 2017/04/10.
 */
public class Main {
    public static void main(String[] args) {
        GlobalDatabase.payrollDB = new PayrollDatabaseImplementation();
        Application application = new PayrollApplication();
        application.SetSource("META-INF/Main.txt");
        Calendar date = new GregorianCalendar(2001, Calendar.OCTOBER, 31);
        int empId = 2;
        Employee e = GlobalDatabase.payrollDB.GetEmployee(empId);
        PaymentClassification pc = e.GetClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        TimeCard tc = hc.GetTimeCard(date);
        System.out.println(tc.GetHours());
    }
}
