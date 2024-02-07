package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //UserGroup.groupUsers();
        try {
            App user = new App("Sasha", -1, "Developer", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
