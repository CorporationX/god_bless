package faang.school.godbless.parallelism.tournament;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class King {
    public static void main(String[] args) {
        final String sirJaimeLannisterName = "Sir Jaime Lannister";
        final String sirOberynMartellName = "Sir Oberyn Martell";

        log.info("Trials begin!");


        Knight sirJaimeLannister = new Knight(sirJaimeLannisterName);

        Trial trial1SirJaime = new Trial(sirJaimeLannisterName, "Trial of Courage");
        Trial trial2SirJaime = new Trial(sirJaimeLannisterName, "Trial of Strategy");

        sirJaimeLannister.addTrial(trial1SirJaime);
        sirJaimeLannister.addTrial(trial2SirJaime);

        sirJaimeLannister.startTrials();


        Knight sirOberynMartell = new Knight(sirOberynMartellName);

        Trial trial1SirOberyn = new Trial(sirOberynMartellName, "Trial of Agility");
        Trial trial2SirOberyn = new Trial(sirOberynMartellName, "Trial of Endurance");

        sirOberynMartell.addTrial(trial1SirOberyn);
        sirOberynMartell.addTrial(trial2SirOberyn);

        sirOberynMartell.startTrials();
    }
}
