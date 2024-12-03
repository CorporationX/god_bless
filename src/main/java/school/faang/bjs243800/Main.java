package school.faang.bjs243800;

public class Main {
    public static void main(String[] args) {
        Character hero1 = new Warrior("Dragon knight");
        Character hero2 = new Archer("Wind ranger");

        hero1.attack(hero2);
        hero2.attack(hero1);
    }
}
