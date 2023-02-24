package at.bbrz.uebungen.textadventure;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final List<Item> equipped = new ArrayList<>();
    private final List<Item> inventory = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void showEq() {
        for(Item item : equipped) {
            System.out.println(item.getName() + " - " + item.getDescription() +
                                " - Weight: " + item.getWeight() + " - Value: " + item.getValue());
        }
    }

    public void showInv() {
        for(Item item : inventory) {
            System.out.println(item.getName() + " - " + item.getDescription() +
                    " - Weight: " + item.getWeight() + " - Value: " + item.getValue());
        }
    }

    public Item getInventoryItem(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void takeItem(Item item) {
        this.inventory.add(item);
    }

    public void dropItem(Item item) {
        this.inventory.remove(item);
    }
}