package faang.school.godbless.BJS2_18615;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");
        warrior.attack(archer);
        System.out.println(archer.name + " has " + archer.health + " health after attack.");
        archer.attack(warrior);
        System.out.println(warrior.name + " has " + warrior.health + " health after attack.");
    }
}
