package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Main {
    public static void main(String[] args) {
        Pikeman pikeman = new Pikeman(1, 5, 5, 6);
        Griffin griffin = new Griffin(2, 8, 10, 8);
        Swordman swordsman = new Swordman(3, 12, 12, 7);
        Angel angel = new Angel(4, 20, 20, 15);

        Hero firstHero = new Hero("Schwarzenegger", "Castle", 100, 10);
        Hero secondHero = new Hero("Emelianenko", "Rampart", 150, 12);

        firstHero.addCreature(pikeman, 20);
        firstHero.addCreature(griffin, 10);
        secondHero.addCreature(swordsman, 15);
        secondHero.addCreature(angel, 5);

        Battlefield battlefield = new Battlefield();
        Hero winner = battlefield.battle(firstHero, secondHero);

        System.out.println("Winner of the battle: " + winner.getName());
    }
}
