package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        System.out.println(archer.getHealth());
        warrior.attack(archer);
        System.out.println(archer.getHealth());
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior.getHealth());
        System.out.println(archer.getHealth());

    }
}
