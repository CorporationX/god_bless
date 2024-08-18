package faang.school.godbless.BJS2_23750;

import java.util.List;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Robert", List.of(
                new Trial("Robert", "Dragon Slaying"),
                new Trial("Robert", "Quest for the Holy Grail"),
                new Trial("Robert", "Saving the Kingdom"),
                new Trial("Robert", "Battle of the Giants"),
                new Trial("Robert", "Rescue Mission")
        ));
        Knight knight2 = new Knight("Sultan", List.of(
                new Trial("Sultan", "Dragon Slaying"),
                new Trial("Sultan", "Quest for the Holy Grail"),
                new Trial("Sultan", "Saving the Kingdom"),
                new Trial("Sultan", "Battle of the Giants"),
                new Trial("Sultan", "Rescue Mission")
        ));

        knight1.startTrials();
        knight2.startTrials();
    }
}
