package faang.school.godbless.BJS2_7907;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Creature> firstArmy = List.of(new Pikeman(8), new Griffin(4));
    List<Creature> secondArmy = List.of(new Swordman(6), new Angel(10));
    Hero firstHero = new Hero("name1", "fraction1", 80, 10, firstArmy);
    Hero secondHero = new Hero("name1", "fraction1", 80, 10, secondArmy);

    Battlefield battlefield = new Battlefield(firstHero, secondHero);
    System.out.println(battlefield.battle());
  }
}
