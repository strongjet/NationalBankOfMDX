package nationalbankofmdx;

import java.util.List;

/**
 *
 * @author Radwane
 */
public class User {

    private final String name;
    private final String surname;
    private final List<Double> transactionList;
    private final BankAccount bankAccount;    

    public User(String n, String s, List<Double> tL, BankAccount bA) {
        this.name = n;
        this.surname = s;
        this.transactionList = tL;
        this.bankAccount = bA;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Double> gettransactionList() {
        return transactionList;
    }    
    
     public void ActionTransactionList() {
        System.out.println("Account " + bankAccount.getAccountNo() + ": current balance is: " + bankAccount.getAccountBalance());
        for (Double transaction : transactionList) {

            if (transaction < 0) {
                System.out.println(name + " " + surname + " is trying to withdraw £" + transaction + " from account number: " + bankAccount.getAccountNo());
                bankAccount.withdraw(transaction);
                System.out.println("New balance on account " + bankAccount.getAccountNo() + " is £" + bankAccount.getAccountBalance());
            } else {

                System.out.println(name + " " + surname + " is depositing £" + transaction + " from account number: " + bankAccount.getAccountNo());
                bankAccount.deposit(transaction);
                System.out.println("New balance on account " + bankAccount.getAccountNo() + " is £" + bankAccount.getAccountBalance());
            }
        }
    }

    public Double userBalance() {
        return bankAccount.getAccountBalance();
    }     
}
