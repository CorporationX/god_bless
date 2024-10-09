package school.faang;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Sergey");
        Character archer = new Archer("Yakov");

        System.out.println("hp - " + archer.getHealth());
        warrior.attack(archer);
        System.out.println("hp - " + archer.getHealth());

        System.out.println("hp - " + warrior.getHealth());
        archer.attack(warrior);
        System.out.println("hp - " + warrior.getHealth());
    }
}
