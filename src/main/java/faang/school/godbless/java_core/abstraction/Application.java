package faang.school.godbless.java_core.abstraction;

public class Application {
    public static void main(String... args) {
        Warrior warrior = new Warrior("Yaroslav");
        Archer archer = new Archer("Kirill");
        warrior.attack(archer);
        warrior.attack(archer);
        System.out.println(archer.getHealth());
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println(archer.getHealth());

    }
}
