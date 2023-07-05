package faang.school.godbless;

import faang.school.godbless.homm_army.Archer;
import faang.school.godbless.homm_army.Army;
import faang.school.godbless.homm_army.Character;
import faang.school.godbless.homm_army.Mage;
import faang.school.godbless.homm_army.Swordsman;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Army army = new Army();

        List<Character> archers = army.generateCharacterList(Archer.class, 30, 3);
        List<Character> swordsmen = army.generateCharacterList(Swordsman.class, 65, 1);
        List<Character> mages = army.generateCharacterList(Mage.class, 100, 1);

        army.addUnits(archers);
        army.addUnits(swordsmen);
        army.addUnits(mages);

        int totalPower = army.calculateTotalPower();

        System.out.println(totalPower);
    }
}
