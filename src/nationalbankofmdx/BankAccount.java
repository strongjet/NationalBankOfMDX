package nationalbankofmdx;

/**
 *
 * @author Radwane
 */


public class BankAccount extends Thread{

    private Double balance;
    private final long accountNo;

    public BankAccount(long accountNo, Double bal) {
        this.accountNo = accountNo;
        this.balance = bal;
    }

    public long getAccountNo() {
        return this.accountNo;
    }

    public Double getAccountBalance() {
        return this.balance;
    }

    public void withdraw(Double bal) {

            if ( (balance + bal) > 0) {

                this.balance += bal; 

                System.out.println("Withdrawing £" + bal + " your new balance now is: £" + balance);

            } else {
                System.out.println("Insufficent money, Withdrawal FAILED!");

            }

    }

    public void deposit(Double bal) {

        this.balance+= bal;
        System.out.println("Depositing £" + bal + " your new balance now is: £" + balance);

    }
}
