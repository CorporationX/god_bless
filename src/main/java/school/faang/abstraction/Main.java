package school.faang.abstraction;

public class Main {

    public static void main(String[] args) {
        Character archer = new Archer("Legolas");
        Character warrior = new Warrior("Ork");

        System.out.println("Legolas health is: " + archer.health);
        System.out.println("Ork health is: " + warrior.health);
        System.out.println();

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("After attack Legolas health is: " + archer.health);
        System.out.println("After attack Ork health is: " + warrior.health);
    }
}
