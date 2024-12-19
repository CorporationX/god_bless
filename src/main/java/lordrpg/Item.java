package lordrpg;

public final class Item {
    private final String name;
    private final int value;

    public Item(String name, int value) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}

