package nationalbankofmdx;

/**
 *
 * @author Radwane
 */


public class BankAccount{

    private Integer balance;
    private long accountNo;

    public BankAccount(long accountNo, int bal) {
        this.accountNo = accountNo;
        this.balance = bal;
    }

    public long getAccountNo() {
        return this.accountNo;
    }

    public int getAccountBalance() {
        return this.balance;
    }

    public void withdraw(int bal) {

            if ( (balance + bal) > 0) {

                this.balance += bal; 

                System.out.println("Withdrawing £" + bal + " your new balance now is: £" + balance);

            } else {
                System.out.println("Insufficent money, Withdrawal FAILED!");

            }

    }

    public void deposit(int bal) {

        this.balance+= bal;
        System.out.println("Depositing £" + bal + " your new balance now is: £" + balance);

    }
}
