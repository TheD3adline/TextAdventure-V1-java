package at.bbrz.uebungen.textadventure;

public class Game {

    private Room currentRoom;
    private Player player;

    public static void main(String[] args) {

        Game game = new Game();

        game.innit();
        game.run();
    }

    private void innit() {
        Room house = new Room("House", "Your house...");
        Room garden = new Room("Garden", "Your garden...");
        Room forrest = new Room("Forrest", "The forrest around your house...");
        Room cave = new Room("Cave", "The cave next to your house...");
        Room river = new Room("River", "The river next to your house...");

        house.addExit("E", garden);
        garden.addExit("W", house);

        garden.addExit("S", forrest);
        forrest.addExit("N", garden);

        forrest.addExit("W", cave);
        cave.addExit("E", forrest);

        forrest.addExit("S", river);
        river.addExit("N", forrest);

        house.addItem(new Item("Broadsword", "The heirloom sword of your family...", 8, 3000));
        house.addItem(new Item("Lamp", "A simple oil lamp, well filled...", 3, 10));
        house.addItem(new Item("Provisions", "Travel provisions for a few days...", 3, 5));

        garden.addItem(new Item("Shovel", "A simple shovel, the grip is split...", 3, 0));

        forrest.addItem(new Item("Mushrooms", "Black and violet mushrooms, they look dangerous...", 1, 0));

        cave.addItem(new Item("Skull", "A human skull...", 2, 0));

        river.addItem(new Item("Boat", "A boat with rudders...", 300, 500));

        currentRoom = house;
        player = new Player("Helm Hammerhand");
    }

    private void run() {
        while (true) {
            System.out.println(currentRoom.getName());
            System.out.println(currentRoom.getDescription());
            System.out.println(currentRoom.showItems());
            System.out.println(currentRoom.showExits());
            playerAction();
            System.out.println();
        }
    }

    private void playerAction() {
        String action = UserInput.getStringInput("Enter your next action: ");

        String[] words = action.split(" ");

        if (words.length > 1) {
            if (words[0].equalsIgnoreCase("take")) {
                for (Item item : currentRoom.getItems()) {
                    if (item.getName().equalsIgnoreCase(words[1])) {
                        player.takeItem(item);
                        currentRoom.getItems().remove(item);
                        break;
                    }
                }
            } else if (words[0].equalsIgnoreCase("drop"))  {
                currentRoom.addItem(player.getInventoryItem(words[1]));
                player.dropItem(player.getInventoryItem(words[1]));
            } else if (words[0].equalsIgnoreCase("show")) {
                if (words[1].equalsIgnoreCase("inv")) {
                    player.showInv();
                } else if (words[1].equalsIgnoreCase("eq")) {
                    player.showEq();
                }
            }
        } else if (currentRoom.findExit(action) != null) {
            currentRoom = currentRoom.findExit(action);
        } else {
            System.out.println("Invalid input! ");
        }
    }
}