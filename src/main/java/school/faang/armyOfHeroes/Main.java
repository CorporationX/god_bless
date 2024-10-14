package school.faang.armyOfHeroes;

import school.faang.armyOfHeroes.army.Army;
import school.faang.armyOfHeroes.heroes.Archer;
import school.faang.armyOfHeroes.heroes.Mage;
import school.faang.armyOfHeroes.heroes.Swordsman;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Army army = new Army();

    army.addHero(new Mage("mage", 50));
    army.addHero(new Mage("mage", 47));
    army.addHero(new Mage("mage", 57));
    army.addHero(new Archer("archer", 25));
    army.addHero(new Archer("archer", 26));
    army.addHero(new Archer("archer", 27));
    army.addHero(new Swordsman("swordsman", 70));
    army.addHero(new Swordsman("swordsman", 100));
    army.addHero(new Swordsman("swordsman", 37));

    System.out.printf("сила всей армии -> %d\n", army.calculateTotalPower());
  }
}
