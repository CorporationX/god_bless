package faang.school.godbless.modul3.tournament;

import java.util.ArrayList;

public class King {
    public static void main(String[] args) {
        Knight gregorClegane = new Knight("Gregor Clegane", new ArrayList<>());
        System.out.println(gregorClegane.getName() + " trials begin!");
        gregorClegane.addTrial(new Trial(gregorClegane.getName(), "Trial of Strength"));
        gregorClegane.addTrial(new Trial(gregorClegane.getName(), "Trial of Endurance"));

        Knight oberynMartell = new Knight("Oberyn Martell", new ArrayList<>());
        System.out.println(oberynMartell.getName() + " trials begin!");
        oberynMartell.addTrial(new Trial(oberynMartell.getName(), "Trial of Agility"));
        oberynMartell.addTrial(new Trial(oberynMartell.getName(), "Trial of Durability"));

        gregorClegane.startTrials();
        oberynMartell.startTrials();
    }
}
