package TextParserTransactionSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransactionApplication.Transaction;
import TransactionApplication.TransactionSource;
import TransactionFactory.TransactionFactory;

/**
 * Created by k2works on 2017/04/10.
 */
public class TextParserTransactionSource extends TransactionSource {
    public String itsSource;
    public TransactionFactory itsTransactionFactory;

    public TextParserTransactionSource(TransactionFactory transactionFactory) {
        itsTransactionFactory = transactionFactory;
    }

    public void Execute() {
        parse();
    }

    private void lineExecute(List<String> line) throws ParseException {
        if (line.size() < 1) {
            System.err.println("Read Line Error");
            return;
        }
        Transaction t = null;
        String transactionName = line.get(0);
        if (transactionName.equals("AddEmp")) {
            t = AddEmp(line);
        } else if (transactionName.equals("ChgEmp")) {
            t = ChgEmp(line);
        } else if (transactionName.equals("DelEmp")) {
            int empId = Integer.parseInt(line.get(1));
            t = itsTransactionFactory.makeDeleteEmployeeTransaction(empId);
        } else if (transactionName.equals("ServiceCharge")) {
            int memberId = Integer.parseInt(line.get(1));
            Calendar date = Calendar.getInstance();
            date.setTime(new SimpleDateFormat("yyyy/MM/dd").parse(line.get(2)));
            double amount = Double.parseDouble(line.get(2));
            t = itsTransactionFactory.makeServiceChargeTransaction(memberId, date, amount);
        }  else if (transactionName.equals("SalesReceipt")) {
            int empId = Integer.parseInt(line.get(1));
            Calendar date = Calendar.getInstance();
            date.setTime(new SimpleDateFormat("yyyy/MM/dd").parse(line.get(2)));
            double amount = Double.parseDouble(line.get(3));
            t = itsTransactionFactory.makeSalesReceiptTransaction(date, amount, empId);
        } else if (transactionName.equals("TimeCard")) {
            int empId = Integer.parseInt(line.get(1));
            Calendar date = Calendar.getInstance();
            date.setTime(new SimpleDateFormat("yyyy/MM/dd").parse(line.get(2)));
            double hours = Double.parseDouble(line.get(3));
            t = itsTransactionFactory.makeTimeCardTransaction(date, hours, empId);
        } else if (transactionName.equals("Payday")) {
            Calendar payDate = Calendar.getInstance();
            payDate.setTime(new SimpleDateFormat("yyyy/MM/dd").parse(line.get(1)));
            t = itsTransactionFactory.makePaydayTransaction(payDate);
        }
        if (t != null) {
            t.Execute();
        }
    }

    public void SetSource(String source) {
        itsSource = source;
    }


    private void parse() {
        if (itsSource == null) {
            System.err.println("Not set Source File");
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(itsSource));
                String line = null;
                while((line = br.readLine()) != null) {
                    String[] lineStrs = line.split(" ");
                    List<String> lineList = new ArrayList<String>();
                    boolean doublequoteFlag = false;
                    StringBuilder sb = null;
                    for(String str : lineStrs) {
                        if(doublequoteFlag) {
                            sb.append(" " + str);
                            if(str.endsWith("\"")) {
                                lineList.add(sb.toString());
                                doublequoteFlag = false;
                            }
                        } else {
                            if(str.startsWith("\"") && str.endsWith("\"") == false) {
                                sb = new StringBuilder(str);
                                doublequoteFlag = true;
                            } else {
                                lineList.add(str);
                            }
                        }
                    }
                    //System.out.println(lineList);
                    lineExecute(lineList);
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }


    public Transaction AddEmp(List<String> line) {
        Transaction t = null;
        int empId = Integer.parseInt(line.get(1));
        if (line.get(4).equals("H")) {
            double hourlyRate = Double.parseDouble(line.get(5));
            t = itsTransactionFactory.makeAddHourlyEmployee(empId, line.get(2),  line.get(3), hourlyRate);
        } else if (line.get(4).equals("S")) {
            double salary = Double.parseDouble(line.get(5));
            t = itsTransactionFactory.makeAddSalariedEmployee(empId, line.get(2), line.get(3), salary);
        } else if (line.get(4).equals("C")) {
            double salary = Double.parseDouble(line.get(5));
            double commissionRate = Double.parseDouble(line.get(6));
            t = itsTransactionFactory.makeAddCommissionedEmployee(empId, line.get(2), line.get(3), salary, commissionRate);
        }
        return t;
    }

    public Transaction ChgEmp(List<String> line) {
        Transaction t = null;
        int empId = Integer.parseInt(line.get(1));
        String changeInfo = line.get(2);
        if (changeInfo.equals("Name")) {
            String name = line.get(3);
            t = itsTransactionFactory.makeChangeNameTransaction(empId, name);
        } else if (changeInfo.equals("Address")) {
            String address = line.get(3);
            t = itsTransactionFactory.makeChangeAddressTransaction(empId, address);
        } else if (changeInfo.equals("Hourly")) {
            double hourly = Double.parseDouble(line.get(3));
            t = itsTransactionFactory.makeChangeHourlyTransaction(empId, hourly);
        } else if (changeInfo.equals("Salaried")) {
            double salary = Double.parseDouble(line.get(3));
            t = itsTransactionFactory.makeChangeSalariedTransaction(empId, salary);
        } else if (changeInfo.equals("Commissioned")) {
            double salary = Double.parseDouble(line.get(3));
            double rate = Double.parseDouble(line.get(4));
            t = itsTransactionFactory.makeChangeCommissionedTransaction(empId, salary, rate);
        } else if (changeInfo.equals("Hold")) {
            t = itsTransactionFactory.makeChangeHoldTransaction(empId);
        } else if (changeInfo.equals("Direct")) {
            String bank = line.get(3);
            String account = line.get(4);
            t = itsTransactionFactory.makeChangeDirectTransaction(empId, bank, account);
        } else if (changeInfo.equals("Mail")) {
            String address = line.get(3);
            t = itsTransactionFactory.makeChangeMailTransaction(0, address);
        } else if (changeInfo.equals("Member")) {
            int memberId = Integer.parseInt(line.get(3));
            double dues = Double.parseDouble(line.get(5));
            t = itsTransactionFactory.makeChangeMemberTransaction(empId, memberId, dues);
        } else if (changeInfo.equals("NoMember")) {
            t = itsTransactionFactory.makeChangeUnaffiliatedTransaction(empId);
        }
        return t;
    }
}