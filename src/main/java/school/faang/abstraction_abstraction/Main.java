package school.faang.abstraction_abstraction;

public class Main {

    public static void main(String[] args) {

        Character archer = new Archer("Archer");
        Character warrior = new Warrior("Warrior");

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println(archer.getName() + " has " + archer.getHp() + "hp after get attacked by warrior");
        System.out.println(warrior.getName() + " has " + warrior.getHp() + "hp after get attacked by archer");
    }
}
