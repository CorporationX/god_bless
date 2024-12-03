package school.faang.abstractions;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Jack");
        Archer archer = new Archer("Mike");

        System.out.println("Warrior's hp = " + warrior.getHp());
        System.out.println("Archer's hp = " + archer.getHp());


        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("Warrior's hp = " + warrior.getHp());
        System.out.println("Archer's hp = " + archer.getHp());
    }
}
