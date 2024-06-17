package faang.school.godbless.bjs2_10928;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Army army = new Army(new ArrayList<>(List.of(new Archer(10), new Swordsman(10), new Mage(10),
        new Archer(22), new Swordsman(22), new Mage(22),
        new Archer(30), new Swordsman(30), new Mage(30))));
    army.addUnit(new Archer(50));
    army.calculateTotalPower();
  }

}
