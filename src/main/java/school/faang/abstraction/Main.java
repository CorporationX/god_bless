package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
       Warrior warrior = new Warrior("Den");
       warrior.attack(warrior);
       Archer archer = new Archer("Sam");
       archer.attack(archer);
    }
}
