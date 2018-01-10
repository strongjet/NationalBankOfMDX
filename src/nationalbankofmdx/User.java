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

    public User(String n, String s, List<Double> tL) {
        this.name = n;
        this.surname = s;
        this.transactionList = tL;
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
    
    
    
    
}
