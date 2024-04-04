package faang.school.godbless.bjs2_4441;

public class Main {
    public static void main(String[] args) {
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Hero hero1 = new Hero("Hero1", "Catchers", 20, 2);
        hero1.addCreature(pikeman, 4);
        Hero hero2 = new Hero("Hero2", "Stark",20, 2);
        hero2.addCreature(griffin, 2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        System.out.println("Battle winner: " + battlefield.battle());
    }
}
