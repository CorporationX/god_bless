package faang.school.godbless.BJS2_4697;

public class Main {
  public static void main(String[] args) {
    Hero hero1 = new Hero("hero1", "fraction1", 10);
    hero1.addCreature(new Swordman("swrd1", 8), 3);
    hero1.addCreature(new Griffin("griffin1", 4), 2);

    Hero hero2 = new Hero("hero2", "fraction2", 11);
    hero2.addCreature(new Angel("angel", 4), 3);
    hero2.addCreature(new Pikeman("pik", 8), 2);

    Battlefield battlefield = new Battlefield(hero1, hero2);

    System.out.println(battlefield.battle());
  }
}
