package org.example;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //  declare scanner object
        Scanner scannerObj = new Scanner(System.in);

        //  ArrayLists for pizzas (String) & quantities (Integer)
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        while (true) {
            //  guide to board for inputs
            System.out.println("\n1. Add Order\n2. Update Order\n3. Remove Order\n4. View Orders\n5. Exit");

            //  option input (1, 2, 3, 4, 5)
            System.out.print("\nChoose Option: ");
            int optionInput = scannerObj.nextInt();

            switch (optionInput) {
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaTypeInput = scannerObj.next();

                    System.out.print("Quantity: ");
                    int quantityInput = scannerObj.nextInt();

                    //  call addOrder method
                    addOrder(pizzas, quantities, pizzaTypeInput, quantityInput);

                    break;
                case 2:
                    //  print out first current order for users to view and update order
                    printOrder(pizzas, quantities);

                    //  input pizza order to update
                    System.out.print("Select pizza order to update: ");
                    int indexInput = scannerObj.nextInt();

                    //  input new quantity of pizza to update
                    System.out.print("New Quantity: ");
                    int newQuantity = scannerObj.nextInt();

                    //  call updateOrder method
                    updateOrder(quantities, indexInput, newQuantity);

                    break;
                case 3:
                    //  print out first current order for users to view and update order
                    printOrder(pizzas, quantities);

                    //  input pizza order to update
                    System.out.print("Select pizza order to remove: ");
                    int indexRemoveInput = scannerObj.nextInt();

                    //  call updateOrder method
                    removeOrder(pizzas, quantities, indexRemoveInput);

                    break;
                case 4:
                    //  print out current order for users to view
                    printOrder(pizzas, quantities);
                    break;
                case 5:
                    System.out.println("--- Thank you! ---");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid Input. Try Again!");
            }
        }
    }

    //  method to add order
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive");
        }
        else {
            pizzas.add(pizzaType);
            quantities.add(quantity);
            System.out.println("\n* Order Added *");
        }
    }

    //  method to update order
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (index > (quantities.size() - 1)) {
            System.out.println("No such order.");
        }
        else if (newQuantity <= 0) {
            System.out.println("Quantity must be positive");
        }
        else {
            quantities.set(index, newQuantity);

            System.out.println("\n* Order Updated *");
        }
    }

    //  method to remove an order
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index > (quantities.size() - 1)) {
            System.out.println("No such order.");
        }
        else {
            pizzas.remove(index);
            quantities.remove(index);

            System.out.println("\n* Order Removed/Updated *");

            //  print out current order for users to view updated order after removing
            printOrder(pizzas, quantities);
        }
    }

    //  method to print out current orders
    public static void printOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        System.out.println("\n--- Current Orders ---");

        for (int i = 0; i < pizzas.size(); i++) {
            System.out.printf("%s. %s X %s\n", i, pizzas.get(i), quantities.get(i));
        }
    }


}