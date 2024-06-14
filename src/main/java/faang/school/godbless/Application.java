package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Hero firstHero = new Hero("Zoltan","Light");
        Hero secondHero = new Hero("Goldran","Darkness");

        Pikeman pikeman = new Pikeman("Pikeman");
        Griffin griffin = new Griffin("Griffin");
        Swordman swordman = new Swordman("Swordman");
        Angel angel = new Angel("Angel");

        firstHero.addCreature(pikeman , 1000);
        firstHero.addCreature(griffin , 500);
        secondHero.addCreature(swordman , 2000);
        secondHero.addCreature(angel , 300);

        firstHero.getArmy();

        Battlefield battlefield = new Battlefield(firstHero , secondHero);
        Hero winner = battlefield.battle();

    }
}