package school.faang.userregistration;

import lombok.Getter;

@Getter
public enum ValidAddresses {
    LONDON("London"),
    NEW_YORK("New York"),
    AMSTERDAM("Amsterdam");

    private final String name;

    ValidAddresses(String name) {
        this.name = name;
    }

    public static boolean isValid(String address) {
        for (ValidAddresses validAddress : values()) {
            if (validAddress.getName().equalsIgnoreCase(address)) {
                return true;
            }
        }
        return false;
    }
}
