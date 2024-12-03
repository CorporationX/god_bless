package school.faang;

public class Main {
    public static void main(String[] args) {
        Character hero1 = new Warrior("Dragon Knight");
        Character hero2 = new Archer("Wind Ranger");

        hero1.attack(hero2);
        hero2.attack(hero1);
    }
}

