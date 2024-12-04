package school.faang.task_43812;

public class Main {
    public static void main(String[] args) {
        Character hero1 = new Archer("Archer");
        Character hero2 = new Warrior("Warrior");

        hero1.attack(hero2);
        hero2.attack(hero1);
        hero2.attack(hero1);

    }
}
