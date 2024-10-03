package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("warrior");
        Archer archer = new Archer("archer");

        warrior.attack(archer);
        System.out.println(archer.getHealth());
    }
}
