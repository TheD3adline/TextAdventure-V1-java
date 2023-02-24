package at.bbrz.uebungen.textadventure;

public class Item {

    private final String name;
    private final String description;
    private final int weight;
    private final int value;

    public Item(String name, String description, int weight, int value) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}