package school.faang.BJS2_61080;

import school.faang.BJS2_61080.army.Army;
import school.faang.BJS2_61080.army.ArmyThread;
import school.faang.BJS2_61080.army.Squad;
import school.faang.BJS2_61080.units.FighterType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad squadArcher = new Squad(
                FighterType.ARCHER,
                new ArrayList<>(List.of(10, 10, 10))
        );

        Squad squadMage = new Squad(
                FighterType.MAGE,
                new ArrayList<>(List.of(20, 20, 20))
        );

        Squad squadSwordMan = new Squad(
                FighterType.SWORDSMAN,
                new ArrayList<>(List.of(30, 30, 30))
        );

        Army blueArmy = new Army(List.of(squadArcher, squadMage, squadSwordMan), "Blue");
        Army redArmy = new Army(List.of(squadArcher, squadMage, squadSwordMan, squadArcher), "Red");

        ArmyThread armyThread = new ArmyThread(List.of(blueArmy, redArmy));
        armyThread.totalArmiesCount();
    }
}
