package faang.school.godbless.BJS2_1281;

import java.util.Arrays;
import java.util.List;

public enum Role {
    LORD("Lord"),
    KNIGHT("Knight"),
    MAGE("Mage");

    private final String string;

    Role(String string) {
        this.string = string;
    }

    public static List<Role> getList() {
        return Arrays.asList(Role.values());
    }

    @Override
    public String toString() {
        return string;
    }
}