package at.bbrz.uebungen.textadventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private final String name;
    private final String description;
    private final List<Item> items = new ArrayList<>();
    private final Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addExit(String direction, Room room) {
        this.exits.put(direction, room);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String showItems() {
        if (items.size() > 0) {
            StringBuilder sb = new StringBuilder();

            sb.append("Items in the near vicinity: ");

            for (Item item : items) {
                sb.append(item.getName());
                sb.append(", ");
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(".");

            return sb.toString();
        }
        return "There are no items in the vicinity.";
    }

    public String showExits() {
        if (exits.size() > 0) {
            StringBuilder sb = new StringBuilder();

            sb.append("Directions to go: ");

            for (String direction : exits.keySet()) {
                if (direction.equalsIgnoreCase("N")) {
                    sb.append("North, ");
                }
                if (direction.equalsIgnoreCase("E")) {
                    sb.append("East, ");
                }
                if (direction.equalsIgnoreCase("S")) {
                    sb.append("South, ");
                }
                if (direction.equalsIgnoreCase("W")) {
                    sb.append("West, ");
                }
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(".");

            return sb.toString();
        }
        return "THERE ARE NO EXITS YOU ARE TRAPPED!!!";
    }

    public Room findExit(String direction) {
        return this.exits.get(direction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }
}