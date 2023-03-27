import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void printInventory() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }
}
