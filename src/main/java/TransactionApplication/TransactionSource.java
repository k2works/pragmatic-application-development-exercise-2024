package TransactionApplication;

/**
 * Created by k2works on 2017/04/10.
 */
public abstract class TransactionSource implements Transaction {
    public abstract void SetSource(String source);
}
