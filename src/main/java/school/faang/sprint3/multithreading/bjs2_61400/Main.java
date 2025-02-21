package school.faang.sprint3.multithreading.bjs2_61400;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Squad<Archer> archerSquad = new Squad<>();
        archerSquad.add(new Archer(15));
        archerSquad.add(new Archer(20));
        archerSquad.add(new Archer(25));

        Squad<Mage> mageSquad = new Squad<>();
        mageSquad.add(new Mage(40));
        mageSquad.add(new Mage(45));
        mageSquad.add(new Mage(50));

        Squad<Swordsman> swordsmanSquad = new Squad<>();
        swordsmanSquad.add(new Swordsman(20));
        swordsmanSquad.add(new Swordsman(30));
        swordsmanSquad.add(new Swordsman(35));

        Army myArmy = new Army(List.of(archerSquad, mageSquad, swordsmanSquad));
        int totalArmyPower = 0;
        try {
            totalArmyPower = myArmy.calculateTotalPower();
        } catch (InterruptedException e) {
            log.warn(e.getMessage());
        }
        System.out.printf("A total power of my army is %d", totalArmyPower);
    }
}
