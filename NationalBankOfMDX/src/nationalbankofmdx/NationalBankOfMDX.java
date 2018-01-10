package nationalbankofmdx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Radwane
 */
public class NationalBankOfMDX {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
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

                            System.out.print("\nThere is a default preset set, please enter 1 if you want to load it up: ");

                            if (input.next().equals("1")) {
                                System.out.println("\n//////////////////INITIALISING USERS//////////////////\n"
                                        + "\nUser 1\n"
                                        + "Name: Saul Goodman\n"
                                        + "Transaction List:\n"
                                        + "£50, £10, -£20,\n"
                                        + "£10, £-20, £20,\n"
                                        + "£10, £50, -£10,\n"
                                        + "£10, £-10, £50\n"
                                        + "\nUser 2\n"
                                        + "Name: Walter White"
                                        + "\nTransaction List:\n"
                                        + "£20, £20, -£20,\n"
                                        + "£50, £-20, £10,\n"
                                        + "£50, £50, -£20,\n"
                                        + "£10, £10\n"
                                        + "\nUser 3\n"
                                        + "Name: Jessie Pinkman\n"
                                        + "Transaction List:\n "
                                        + "£50, £10, £10,\n"
                                        + "-£10, £-10, £50,\n"
                                        + "£20, -£10, -£20\n"
                                        + "\nUser 4\n"
                                        + "Name: Hank Schrader\n"
                                        + "Transaction List:\n"
                                        + "£50, £10, -£20,\n"
                                        + "£20, £10, -£20\n");

                                Users.add("Saul:Goodman:" + EnteredBankA);
                                transactionList.add(Arrays.asList(Double.parseDouble(EnteredBankA), 50.0, 10.0, -20.0, 10.0, -20.0, 20.0, 10.0, 50.0, -10.0, 10.0, -10.0, 50.0));
                                Users.add("Walter:White:" + EnteredBankA);
                                transactionList.add(Arrays.asList(Double.parseDouble(EnteredBankA), 20.0, 20.0, -20.0, 50.0, -20.0, 10.0, 50.0, 50.0, -20.0, 10.0, 10.0));
                                Users.add("Jessie:Pinkman:" + EnteredBankA);
                                transactionList.add(Arrays.asList(Double.parseDouble(EnteredBankA), 50.0, 10.0, 10.0, -10.0, -10.0, 50.0, 20.0, -10.0, -20.0));
                                Users.add("Hank:Schrader:" + EnteredBankA);
                                transactionList.add(Arrays.asList(Double.parseDouble(EnteredBankA), 50.0, 10.0, -20.0, 20.0, 10.0, -20.0));

                            } else {

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

                                    for (int p = 1; p <= TransactionNo; p++) {
                                        System.out.print("\nFor transaction Number " + p + " please enter for "
                                                + "Deposits (10, 20 or 50) or Withdrawals (-10, -20 or -50): ");
                                        correct_in = false;
                                        while (correct_in == false) {
                                            Menu_selection = input.next();
                                            if (!Menu_selection.matches("^.*?(10|20|50|-10|-20|-50).*$")) {
                                                System.out.print("INVLID INPUT, Please enter for Deposits (10, 20 or 50) or"
                                                        + " Withdrawals (-10, -20 or -50): ");
                                            } else {
                                                transactionListSetup.add(Double.parseDouble(Menu_selection));
                                                correct_in = true;
                                            }
                                        }
                                    }
                                    transactionList.add(transactionListSetup);
                                    Users.add(firstname + ":" + surname + ":" + EnteredBankA);
                                }

                            }
                            correct_in = false;
                        } else {
                            System.out.println("\n\nERROR, THE ACCOUNT YOU HAVE ENTERED DOES NOT EXIST\n\n");
                            correct_in = false;
                        }
                    } else {
                        System.out.println("\n\nERROR, PLEASE CREATE A BANK ACCOUNT. NO BANK ACCOUNT EXISTS\n\n");
                        correct_in = false;
                    }
                    break;
                case "3":

                    System.out.print("\n############SIMULATION MODE############\n"
                            + "\n$$$$$$$$$$$$$$$$ PLEASE ENTER THE ACCOUNT NUMBER YOU WANT TO SIMULATE $$$$$$$$$$$$$$$$\n"
                            + "Account number input....: ");

                    correct_in = false;
                    while (correct_in == false) {
                        Menu_selection = input.next();

                        if (!BankA_no.contains(Menu_selection)) {
                            System.out.print("Please enter a account number, type 0 to exit: ");
                            if (Menu_selection.equals(0)) {
                                break;
                            }
                        } else {

                            double balance = 0;
                            for (String temp : BankA_no) {
                                if (temp.contains(Menu_selection + " :")) {
                                    String AccountnBalance[] = temp.split(":");

                                    balance = Double.parseDouble(AccountnBalance[1]);
                                }
                            }
                            BankAccount Mainthread = new BankAccount(Long.parseLong(Menu_selection), balance);
                            Mainthread.start();
                            int iterator = 0;
                            List<Double> UserTransactionList = null;

                            for (String temp : Users) {
                                String AccountNoVerify[] = temp.split(":");
                                if (AccountNoVerify[2].equals(Menu_selection)) {
                                    System.out.println("<>First Name: " + AccountNoVerify[0]);
                                    System.out.println("<>Surname: " + AccountNoVerify[1]);
                                    System.out.println("<>Account number: " + AccountNoVerify[2]);
                                    int iterator2 = 0;
                                    for (List<Double> temp2 : transactionList) {
                                        if (temp2.get(0).equals(Double.parseDouble(AccountNoVerify[2])) && iterator2 <= iterator) {
                                            Integer ListSize = temp2.size();
                                            List<Double> temp22 = temp2.subList(1, ListSize);
                                            UserTransactionList = temp22;
                                            iterator2 += 1;
                                        }
                                    }

                                    Runner thread = new Runner(new User(AccountNoVerify[0], AccountNoVerify[1], UserTransactionList, Mainthread));

                                    executor.execute(thread);
                                }
                                iterator += 1;
                            }

                            executor.shutdown();

                            while (!executor.isTerminated()) {
                            }

                            break;
                        }
                    }

                case "4":
                    System.exit(0);
            }

        }

    }

}
