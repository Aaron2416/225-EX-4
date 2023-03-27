import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Room currentRoom;
    private ArrayList<Room> allRooms;
    private Random random;
    private Inventory inventory;

    public void init() {
        Room mainHall = new Room("You are in the main hall.", 1, new Item("key", "a shiny key"), new Character("wizard", "a wise old wizard"));
        Room diningRoom = new Room("You are in the dining room.", 2, new Item("book", "an ancient book"), new Character("ghost", "a spooky ghost"));
        Room kitchen = new Room("You are in the kitchen.", 3, new Item("apple", "a juicy red apple"), new Character("chef", "a friendly chef"));

        allRooms = new ArrayList<>();
        allRooms.add(mainHall);
        allRooms.add(diningRoom);
        allRooms.add(kitchen);

        currentRoom = mainHall;

        inventory = new Inventory();

        describeCurrentRoom();
    }

    public Game() {
        allRooms = new ArrayList<>();
        random = new Random();
    }

    public void move(int roomNumber) {
        if (random.nextDouble() < 0.1) {
            currentRoom = getRandomRoom();
        } else {
            currentRoom = getRoomByNumber(roomNumber);
        }

        describeCurrentRoom();
    }

    public void describeCurrentRoom() {
        System.out.println("You are in room " + currentRoom.getNumber() + ".");
        System.out.println(currentRoom.getDescription());

        if (currentRoom.hasItem()) {
            System.out.println("You see a " + currentRoom.getItem().getName() + ".");
        }

        if (currentRoom.isOccupied()) {
            System.out.println("You see " + currentRoom.getCharacter().getName() + ".");
        }

        System.out.println("Where would you like to go?");
        for (Room room : allRooms) {
            if (room.getNumber() != currentRoom.getNumber()) {
                System.out.println("[" + room.getNumber() + "] " + room.getDescription());
            }
        }

        System.out.println("[I] View Inventory");
        System.out.println("[Q] Quit Game");
    }

    public Inventory getInventory() {
        return inventory;
    }

    private Room getRandomRoom() {
        int randomIndex = random.nextInt(allRooms.size());
        return allRooms.get(randomIndex);
    }

    private Room getRoomByNumber(int roomNumber) {
        for (Room room : allRooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
