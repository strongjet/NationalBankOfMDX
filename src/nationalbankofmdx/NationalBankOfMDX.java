package nationalbankofmdx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Radwane
 */
public class NationalBankOfMDX {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<String> BankA_no = new ArrayList<>();
        List<String> Users = new ArrayList<>();
        List<List<Double>> transactionList = new ArrayList<>();
        List<Double> transactionListSetup = new ArrayList<>();

        boolean correct_in = false;
        while (true) {

            String CurrentBankA = null, Balance = null, Menu_selection = null, EnteredBankA = null;
            Integer UserNo = 0, TransactionNo = 0;

            while (correct_in == false) {
                System.out.print("\nWelcome to the Nation Bank of Middlesex - MAIN MENU  (created by M00566185)\n"
                        + "Please enter numbers 1-4 to select an option in the menu below\n\n"
                        + "1. Create Bank Account\n"
                        + "2. Create User\n"
                        + "3. Run Simulation\n"
                        + "4. Exit\n"
                        + "Selection choice: ");

                Menu_selection = input.next();
                if (Menu_selection.matches("[1-4]")) {
                    correct_in = true;
                }
            }

        }

    }

}
