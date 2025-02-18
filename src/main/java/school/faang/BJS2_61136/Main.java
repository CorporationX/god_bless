package school.faang.BJS2_61136;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Archer> archerList = new ArrayList<>();
        List<Mage> mageList = new ArrayList<>();
        List<Swordsman> swordsmenList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            archerList.add(new Archer());
            mageList.add(new Mage());
            swordsmenList.add(new Swordsman());
        }

        Squad<Archer> archerSquad = new Squad<>(archerList);
        Squad<Mage> mageSquad = new Squad<>(mageList);
        Squad<Swordsman> swordsmanSquad = new Squad<>(swordsmenList);

        List<Squad<? extends Warrior>> squadList = new ArrayList<>();
        squadList.add(archerSquad);
        squadList.add(swordsmanSquad);
        squadList.add(mageSquad);

        Army army = new Army(squadList);

        System.out.println(army.calculateTotalPower());
    }
}
