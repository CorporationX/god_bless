package faang.school.godbless.BJS2_18532;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Aragorn");
        Character archer = new Archer("Legolas");

        System.out.println(warrior.name + "'s health: " + warrior.health);
        System.out.println(archer.name + "'s health: " + archer.getHealth());

        System.out.println(warrior.getName() + " is attacking " + archer.getName());
        warrior.attack(archer);
        System.out.println(archer.getName() + "'s health: " + archer.getHealth());
        System.out.println(archer.getName() + " is attacking " + warrior.getName());
        archer.attack(warrior);
        System.out.println(warrior.getName() + "'s health: " + warrior.getHealth());
    }
}