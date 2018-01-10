package nationalbankofmdx;

/**
 *
 * @author Radwane
 */
public class Runner extends Thread {

    private final User person;

    Runner(User user) {
        this.person = user;
    }

    @Override
    public void run() {

        System.out.println("TRANSACTION begining");
        System.out.println("Transactions to be completed by " + this.person.getName() + " " + this.person.getSurname());
        System.out.println(this.person.gettransactionList());
        this.person.ActionTransactionList();
        System.out.println("FINAL BALANCE is £" + this.person.userBalance());

    }

}
