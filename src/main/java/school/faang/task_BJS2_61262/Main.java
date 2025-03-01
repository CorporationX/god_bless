package school.faang.task_BJS2_61262;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Archer archerAlex = new Archer(20);
        Archer archerBob = new Archer(20);
        Swordsman swordsmanAlex = new Swordsman(30);
        Swordsman swordsmanBob = new Swordsman(30);
        Mage mageAlex = new Mage(40);
        Mage mageBob = new Mage(40);

        Squad archerSquad = new Squad(List.of(archerAlex, archerBob));
        Squad sworsmanSquad = new Squad(List.of(swordsmanAlex, swordsmanBob));
        Squad mageSquad = new Squad(List.of(mageAlex, mageBob));

        Army army = new Army(List.of(archerSquad, sworsmanSquad, mageSquad));

        try {
            System.out.println("Total army power: " + army.calculateTotalPower());
        } catch (InterruptedException e) {
            System.err.println("Error: the program was interrupted " + e.getMessage());
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("Error when total army power was calculated " + e.getMessage());
            e.printStackTrace();
        }
    }
}