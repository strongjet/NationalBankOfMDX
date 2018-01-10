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

            switch (Menu_selection) {
                case "1":
                    System.out.print('\f'
                            + "\nInitialising bank account creation...\n\n"
                            + "Please enter the Bank Account Number: ");
                    CurrentBankA = input.next();
                    if (CurrentBankA.matches("[0-9]+") && !BankA_no.contains(CurrentBankA)) {
                        correct_in = false;
                        System.out.println("\nBank Account Number: " + CurrentBankA);
                        System.out.print("\n\nPlease enter the Bank Account Starting Balance, be sure you don't make a mistake: \n£");
                        BankA_no.add(CurrentBankA);
                        Balance = input.next();
                        if (Balance.matches("\\d+(\\.\\d{1,2})?")) {
                            BankA_no.add(CurrentBankA + " :" + Balance);
                            correct_in = false;
                            System.out.println("\nBank Account " + CurrentBankA + " created with balance £" + Balance + "\n");
                        } else {
                            System.out.println("\n\n ERROR, PLEASE ENTER A VALID BALANCE\n\n");
                        }
                        break;
                    } else {
                        System.out.println("\n\n ERROR, PLEASE ENTER A VALID BANK ACCOUNT NUMBER <DUPLICATES AREN@T VALID>\n\n");
                    }

                case "2":

                    if (!BankA_no.isEmpty()) {

                        System.out.print("\nPlease enter a Bank Account Number that this user is to be added to: ");
                        EnteredBankA = input.next();
                        if (BankA_no.contains(EnteredBankA)) {

                            System.out.print("\nHow many users do you want to add to " + EnteredBankA + ": ");
                            correct_in = false;
                            while (correct_in == false) {
                                Menu_selection = input.next();
                                if (!Menu_selection.matches("[0-9]+")) {
                                    System.out.print("Please enter a valid number of users, if none type 0: ");
                                } else {
                                    correct_in = true;
                                    UserNo = Integer.parseInt(Menu_selection);
                                }
                            }

                            String firstname, surname;

                            for (int i = 1; i <= UserNo; i++) {
                                System.out.print("\nFor USER " + i + " - \n");
                                System.out.print("Please enter user's FIRST name: ");
                                firstname = input.next();
                                System.out.print("Please enter user's SURNAME: ");
                                surname = input.next();
                                System.out.print("\nHow many transactions do you want to add to " + firstname + " " + surname + ": ");
                                correct_in = false;
                                while (correct_in == false) {
                                    Menu_selection = input.next();
                                    if (!Menu_selection.matches("[0-9]+")) {
                                        System.out.print("Please enter a valid number of users, if none type 0: ");
                                    } else {
                                        correct_in = true;
                                        TransactionNo = Integer.parseInt(Menu_selection);
                                    }
                                }
                                transactionListSetup.clear();

                            }
                        } else {
                            System.out.println("\n\nERROR, THE ACCOUNT YOU HAVE ENTERED DOES NOT EXIST\n\n");
                            correct_in = false;
                        }
                    } else {
                        System.out.println("\n\nERROR, PLEASE CREATE A BANK ACCOUNT. NO BANK ACCOUNT EXISTS\n\n");
                        correct_in = false;
                    }
                    break;
            }

        
    

case "3":
                case "4":
                    System.exit(0);

            }

        }

    }

}
