package faang.school.godbless.mt.tasks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Chore> chores = List.of(
                new Chore("Cleaning", 22),
                new Chore("Cooking", 4),
                new Chore("Repair", 6),
                new Chore("Reading", 2)
        );

        new WeasleyFamily(chores).startChores();
    }
}
