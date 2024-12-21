package derschrank.sprint01.task02.bjstwo_43966;

public enum Activity {
    MUSIC("Music"),
    COOKING("Cooking"),
    HIKING("Hiking"),
    READING("Reading"),
    GARDENING("Gardening"),
    PHOTOGRAPHY("Photography"),
    TRAVELING("Traveling"),
    CYCLING("Cycling");

    private final String name;

    Activity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
