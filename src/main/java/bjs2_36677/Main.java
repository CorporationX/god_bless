package bjs2_36677;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> chores = List.of(
                "chore1",
                "chore2",
                "chore3",
                "chore4",
                "chore5",
                "chore6",
                "chore7");

        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
        weasleyFamily.doChores();
    }
}
