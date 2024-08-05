package invmang;

import java.util.Scanner;

public class InventoryManagementSystem {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    viewItem();
                    break;
                case 5:
                    listAllItems();
                    break;
                case 6:
                    displayTotalInventoryValue();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nInventory Management System Menu:");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Update Item");
        System.out.println("4. View Item");
        System.out.println("5. List All Items");
        System.out.println("6. Display Total Inventory Value");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        inventory.addItem(name, quantity, price);
    }

    private static void removeItem() {
        System.out.print("Enter item ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.removeItem(id);
    }

    private static void updateItem() {
        System.out.print("Enter item ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new item quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter new item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        inventory.updateItem(id, name, quantity, price);
    }

    private static void viewItem() {
        System.out.print("Enter item ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.viewItem(id);
    }

    private static void listAllItems() {
        inventory.listAllItems();
    }

    private static void displayTotalInventoryValue() {
        double totalValue = inventory.getTotalInventoryValue();
        System.out.println("Total inventory value: $" + totalValue);
    }
}
