public class Room {
    private String description;
    private int number;
    private Item item;
    private Character character;

    public Room(String description, int number, Item item, Character character) {
        this.description = description;
        this.number = number;
        this.item = item;
        this.character = character;
    }

    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }

    public boolean hasItem() {
        return item != null;
    }

    public Item getItem() {
        return item;
    }

    public boolean isOccupied() {
        return character != null;
    }

    public Character getCharacter() {
        return character;
    }
}
