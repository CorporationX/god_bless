package faang.school.godbless;

public enum Addresses {
    LONDON("London"), NY("New York"), AMSTERDAM("Amsterdam");

    private final String name;

    Addresses(String str) {
        name = str;
    }

    public boolean equalsName(String otherName) {
        return this.name.equals(otherName);
    }

    public static boolean contains(String name) {
        for (Addresses address : Addresses.values()) {
            if (address.name.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static Addresses fromString(String name) {
        for (Addresses address : Addresses.values()) {
            if (address.name.equalsIgnoreCase(name)) {
                return address;
            }
        }
        return null;
    }
}
