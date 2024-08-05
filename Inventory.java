package invmang;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, int quantity, double price) {
        Item newItem = new Item(name, quantity, price);
        items.add(newItem);
        System.out.println("Item added successfully: " + newItem);
    }

    public void removeItem(int id) {
        Optional<Item> itemToRemove = items.stream().filter(item -> item.getId() == id).findFirst();
        if (itemToRemove.isPresent()) {
            items.remove(itemToRemove.get());
            System.out.println("Item removed successfully: " + itemToRemove.get());
        } else {
            System.out.println("Item not found with ID: " + id);
        }
    }

    public void updateItem(int id, String name, int quantity, double price) {
        Optional<Item> itemToUpdate = items.stream().filter(item -> item.getId() == id).findFirst();
        if (itemToUpdate.isPresent()) {
            Item item = itemToUpdate.get();
            item.setName(name);
            item.setQuantity(quantity);
            item.setPrice(price);
            System.out.println("Item updated successfully: " + item);
        } else {
            System.out.println("Item not found with ID: " + id);
        }
    }

    public void viewItem(int id) {
        Optional<Item> itemToView = items.stream().filter(item -> item.getId() == id).findFirst();
        if (itemToView.isPresent()) {
            System.out.println("Item details: " + itemToView.get());
        } else {
            System.out.println("Item not found with ID: " + id);
        }
    }

    public void listAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            System.out.println("All items in inventory:");
            items.forEach(System.out::println);
        }
    }
    public double getTotalInventoryValue() {
        double totalValue = 0;
        for (Item item : items) {
            totalValue += item.getPrice() * item.getQuantity();
        }
        return totalValue;
    }
}
