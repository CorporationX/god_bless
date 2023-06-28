package faang.school.godbless;

import java.util.ArrayList;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("Ser Loras Tyrell", new ArrayList<>());
        knight1.addTrial(new Trial(knight1.getName(), "Jousting"));
        knight1.addTrial(new Trial(knight1.getName(), "Sword fighting"));

        Knight knight2 = new Knight("Ser Barristan Selmy", new ArrayList<>());
        knight2.addTrial(new Trial(knight2.getName(), "Archery"));
        knight2.addTrial(new Trial(knight2.getName(), "Horsemanship"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
