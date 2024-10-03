package school.faang.usercollection;

public enum HobbyTypes {
    RUNNING("Running"),
    YOGA("Yoga"),
    CYCLING("Cycling"),
    ROLLERBLADING("Rollerblading"),
    SCOOTERING("Scootering"),
    BASKETBALL("Basketball"),
    VOLLEYBALL("Volleyball"),
    FOOTBALL("Football");

    private final String name;

    HobbyTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
