package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Arthur");
        Archer archer = new Archer("Robin");

        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println(warrior.getName() + " health after" + archer.getName() + " attacked: " + warrior.getHealth());

        warrior.attack(archer);
        System.out.println(archer.getName() + " health after " + warrior.getName() + " attacked: " + archer.getHealth());

    }
}
