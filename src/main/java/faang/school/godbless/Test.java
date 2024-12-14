package faang.school.godbless;

public class Test {
    public static void main(String[] args) {
        Character warrior = new Warrior("John");
        Character archer = new Archer("Steve");

        System.out.println("Warrior health: " + warrior.getHealth());
        System.out.println("Archer health: " + archer.getHealth());
        warrior.attack(archer);

        System.out.println("_____________________________________");
        System.out.println("Archer health: " + archer.getHealth());
        System.out.println("_____________________________________");

        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println("Warrior health: " + warrior.getHealth());
        System.out.println("Archer health: " + archer.getHealth());
        System.out.println("_____________________________________");


    }
}
