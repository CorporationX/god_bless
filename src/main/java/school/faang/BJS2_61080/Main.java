package school.faang.BJS2_61080;

import school.faang.BJS2_61080.army.Army;
import school.faang.BJS2_61080.army.ArmyThread;
import school.faang.BJS2_61080.army.Squad;
import school.faang.BJS2_61080.units.Archer;
import school.faang.BJS2_61080.units.Mage;
import school.faang.BJS2_61080.units.SwordsMan;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        Squad redSquadArcher = new Squad(new Archer(), random.nextInt(4));
        Squad redSquadMage = new Squad(new Mage(), random.nextInt(4));
        Squad redSquadSwordMan = new Squad(new SwordsMan(), random.nextInt(4));
        Army redArmy = new Army(List.of(redSquadArcher, redSquadMage, redSquadSwordMan), "Red");

        Squad blueSquadArcher = new Squad(new Archer(), random.nextInt(4));
        Squad blueSquadMage = new Squad(new Mage(), random.nextInt(4));
        Squad blueSquadSwordMan = new Squad(new SwordsMan(), random.nextInt(4));
        Army blueArmy = new Army(List.of(blueSquadArcher, blueSquadMage, blueSquadSwordMan), "Blue");

        ArmyThread armyThread = new ArmyThread(List.of(blueArmy, redArmy));
        armyThread.totalArmiesCount();
    }
}
