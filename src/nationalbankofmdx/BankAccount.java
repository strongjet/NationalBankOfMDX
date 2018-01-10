package nationalbankofmdx;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Radwane
 */


public class BankAccount extends Thread{

    private AtomicInteger balance;
    private final long accountNo;

    public BankAccount(long accountNo, int bal) {
        this.accountNo = accountNo;
        this.balance = new AtomicInteger(bal);
    }

    public long getAccountNo() {
        return this.accountNo;
    }

    public AtomicInteger getAccountBalance() {
        return this.balance;
    }

    public synchronized void withdraw(double bal) {
        try {

            if (balance.addAndGet((int) bal) > 0) {

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Withdrawing £" + bal + " your new balance now is: £" + balance);

            } else {
                System.out.println("Insufficent money, Withdrawal FAILED!");
                balance.addAndGet((int) bal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double bal) {

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Depositing £" + bal + " your new balance now is: £" + balance.addAndGet((int) bal));

    }
}
