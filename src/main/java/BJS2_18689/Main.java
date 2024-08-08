package BJS2_18689;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Legolas");
        Character warrior = new Warrior("Aragorn");

        archer.attack(warrior);
        System.out.println(archer.name + " attacked " + warrior.name + " health remaining - " + warrior.health);
        warrior.attack(archer);
        System.out.println(warrior.name + " attacked " + archer.name + " health remaining - " + archer.health);

    }
}
