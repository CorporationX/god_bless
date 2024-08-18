package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();

        // Create instances of heroes
        Hero hero1 = new Hero();
        hero1.setName("Arthur");
        hero1.addCreature(pikeman, 20);
        hero1.addCreature(griffin, 10);

        Hero hero2 = new Hero();
        hero2.setName("Lancelot");
        hero2.addCreature(swordman, 15);
        hero2.addCreature(angel, 5);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        // Output the result
        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        } else {
            System.out.println("It's a draw!");
        }
    }
}