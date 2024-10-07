package school.faang.godbless.bjs2_32851;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    Hero dasha = new Hero("Dasha", "Guards", 234121, 54);
    dasha.addCreature(new Pikeman("Elite guard", 20), 100);
    dasha.addCreature(new Swordman("Recruit", 5), 20);
    dasha.addCreature(new Angel("Guard holy angel", 50), 1);

    Hero masha = new Hero("Masha", "Bandits", 65231, 35);
    masha.addCreature(new Griffin("Bandit pet griffin", 10), 80);

    Battlefield battlefield = new Battlefield(dasha, masha);

    Optional<Hero> winner = battlefield.battle();
    if (winner.isEmpty()) {
      System.out.println("Players destroyed each other");
    } else {
      System.out.println("The winner is " + winner.get().getName());
    }
  }
}
