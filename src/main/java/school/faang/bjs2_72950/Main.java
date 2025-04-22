package school.faang.bjs2_72950;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> choresList =
            List.of("wash the dishes", "clean the floor", "wipe off the dust", "chopping wood", "prepare food",
                "chore #001", "chore #002", "chore #003", "chore #004", "chore #005");
        WeasleyFamily family = new WeasleyFamily(choresList);
        try {
            family.performChores();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
