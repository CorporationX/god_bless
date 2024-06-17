package faang.school.godbless.abstraction;

public class Application {
    public static void main(String[] args) {
        Warrior war1 = new Warrior("Knight");
        Archer archer1 = new Archer("Bowman");

        war1.attack(archer1);
        war1.attack(archer1);
        archer1.attack(war1);
        System.out.println(archer1.health);
        System.out.println(war1.health);
        System.out.println(war1.getName());
    }
}