/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jstore;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class JStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean usab = true;
        ImageIcon icon1 = new ImageIcon("shesh na icon.png");
        Image shesh = icon1.getImage();
        Image resizedImage = shesh.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        Image resizedImage2 = shesh.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);

        while (usab) {
            // Input name
            String name = JOptionPane.showInputDialog(null, "Input Your Name", "Hogwarts' Bookstore", JOptionPane.PLAIN_MESSAGE);

            if (name == null) {
                int piliBruh = JOptionPane.showConfirmDialog(null, "Do You Want to Exit?");
                if (piliBruh == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Thank You For Visiting!");
                    usab = false;
                    break;
                } else {
                    continue;
                }
            } else if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "It seems that your name is empty. Please input your name!");
                continue;
            }

            // this part will greet the user
            String[] nameOption = {"Proceed", "Change Name", "Exit"};
            int answer1 = JOptionPane.showOptionDialog(
                    null,
                    "Hello, " + name + "! Welcome to Hogwarts' Bookstore.",
                    "Welcome, " + name + "!",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    resizedIcon,
                    nameOption,
                    nameOption[0]);

            if (answer1 == 1) {
                continue;
            } else if (answer1 == 2 || answer1 == -1) {
                JOptionPane.showMessageDialog(null, "Come again, " + name + "!");
                usab = false;
                break;
            }

            while (true) {
                int partialTotal = 0; // Clears the total for a fresh start
                String orderSummary = ""; // Clears the order summary for a fresh start
                boolean keepShopping = true;

                while (keepShopping) {
                    String[] books = {
                        "BOOK 1: Harry Potter and the Sorcerer's Stone----------PRICE: Php 800",
                        "BOOK 2: Harry Potter and the Chamber of Secrets------PRICE: Php 750",
                        "BOOK 3: Harry Potter and the Prisoner of Azkaban------PRICE: Php 900",
                        "BOOK 4: Harry Potter and the Goblet of Fire----------------PRICE: Php 820",
                        "BOOK 5: Harry Potter and the Order of the Phoenix------PRICE: Php 780",
                        "BOOK 6: Harry Potter and the Half-Blood Prince----------PRICE: Php 830",
                        "BOOK 7: Harry Potter and the Deathly Hallows------------PRICE: Php 720"
                    };

                    String selectionBooks = (String) JOptionPane.showInputDialog(
                            null,
                            "SELECT YOUR DESIRED BOOK\n\n" + String.join("\n", books),
                            "Hogwarts' Bookstore",
                            JOptionPane.PLAIN_MESSAGE,
                            resizedIcon2,
                            books,
                            books[0]);

                    if (selectionBooks == null) {
                        int confirmCancel = JOptionPane.showConfirmDialog(null, "Do you want to stop shopping?");
                        if (confirmCancel == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank You For Coming, " + name + "!");
                            keepShopping = false;
                            break;
                        } else {
                            continue;
                        }
                    }

                    int bookPrice = 0;
                    String bookName = "";
                    switch (selectionBooks) {
                        case "BOOK 1: Harry Potter and the Sorcerer's Stone----------PRICE: Php 800":
                            bookName = "Harry Potter and the Sorcerer's Stone";
                            bookPrice = 800;
                            break;
                        case "BOOK 2: Harry Potter and the Chamber of Secrets------PRICE: Php 750":
                            bookName = "Harry Potter and the Chamber of Secrets";
                            bookPrice = 750;
                            break;
                        case "BOOK 3: Harry Potter and the Prisoner of Azkaban------PRICE: Php 900":
                            bookName = "Harry Potter and the Prisoner of Azkaban";
                            bookPrice = 900;
                            break;
                        case "BOOK 4: Harry Potter and the Goblet of Fire----------------PRICE: Php 820":
                            bookName = "Harry Potter and the Goblet of Fire";
                            bookPrice = 820;
                            break;
                        case "BOOK 5: Harry Potter and the Order of the Phoenix------PRICE: Php 780":
                            bookName = "Harry Potter and the Order of the Phoenix";
                            bookPrice = 780;
                            break;
                        case "BOOK 6: Harry Potter and the Half-Blood Prince----------PRICE: Php 830":
                            bookName = "Harry Potter and the Half-Blood Prince";
                            bookPrice = 830;
                            break;
                        case "BOOK 7: Harry Potter and the Deathly Hallows------------PRICE: Php 720":
                            bookName = "Harry Potter and the Deathly Hallows";
                            bookPrice = 720;
                            break;
                    }

                    String[] quantities = {"1 pc.", "2 pcs.", "3 pcs.", "4 pcs.", "5 pcs."};
                    int quantityIndex = JOptionPane.showOptionDialog(
                            null,
                            "You selected: " + bookName + "\nPrice: Php " + bookPrice + "\nSelect Quantity [MAX: 5 pcs.]",
                            "Book Quantity",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            resizedIcon2,
                            quantities,
                            quantities[0]);

                    if (quantityIndex == -1) {
                        JOptionPane.showMessageDialog(null, "No quantity selected. Returning to main menu.");
                        continue;
                    }

                    int quantity = quantityIndex + 1;
                    int subtotal = bookPrice * quantity;
                    partialTotal += subtotal;
                    orderSummary += bookName + " x" + quantity + " = Php " + subtotal + "\n";

                    String[] cartOptions = {"Select Another Item", "Checkout", "Cancel Order"};
                    int cartChoice = JOptionPane.showOptionDialog(
                            null,
                            "Current Order Summary:\n" + orderSummary + "\nTotal: Php " + partialTotal,
                            "Cart Menu",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            resizedIcon2,
                            cartOptions,
                            cartOptions[0]);

                    if (cartChoice == 0) {
                        continue;
                    } else if (cartChoice == 1) { // Checkout menu
                        int remainingAmount = partialTotal;
                        int attempts = 3;

                        while (attempts > 0) {
                            String payInput = JOptionPane.showInputDialog(
                                    null,
                                    "Your total is Php " + remainingAmount + ". Enter payment amount:\n"
                                    + "You have " + attempts + " attempt(s) left.",
                                    "Checkout",
                                    JOptionPane.PLAIN_MESSAGE);

                            if (payInput == null) {
                                JOptionPane.showMessageDialog(null, "Checkout canceled. Returning to menu.");
                                break;
                            }

                            try {
                                int payment = Integer.parseInt(payInput);

                                if (payment < 0) {
                                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a positive amount.");
                                    continue;
                                }

                                if (payment >= remainingAmount) {
                                    int change = payment - remainingAmount;

                                    // Displays Receipt
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Receipt\n\n" + orderSummary + "\nTotal: Php " + partialTotal
                                            + "\nPayment: Php " + payment + "\nChange: Php " + change,
                                            "Transaction Successful",
                                            JOptionPane.INFORMATION_MESSAGE
                                    );

                                    // this part will Ask if user wants to shop again
                                    int shopAgain = JOptionPane.showConfirmDialog(
                                            null,
                                            "Would you like to buy more books?",
                                            "Continue Shopping?",
                                            JOptionPane.YES_NO_OPTION
                                    );

                                    if (shopAgain == JOptionPane.YES_OPTION) {
                                        orderSummary = ""; // Clears the order summary
                                        partialTotal = 0;  // Resets the total
                                    } else {
                                        keepShopping = false;
                                        usab = false;
                                    }
                                    break;
                                } else {
                                    remainingAmount -= payment;
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Insufficient payment! Remaining amount to pay: Php " + remainingAmount,
                                            "Payment Needed",
                                            JOptionPane.WARNING_MESSAGE
                                    );
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                            }

                            attempts--;

                            if (attempts == 0) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Transaction failed! You have exceeded the maximum payment attempts.\nReturning to the menu.",
                                        "Transaction Failed",
                                        JOptionPane.ERROR_MESSAGE
                                );
                                break;
                            }
                        }
                    } else if (cartChoice == 2) { // Cancels the Order
                        orderSummary = "";
                        partialTotal = 0;
                        JOptionPane.showMessageDialog(null, "Your cart has been cleared. Returning to menu.");
                    }
                }
                break;
            }
        }
    }

}
