package school.faang;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Adam");
        Archer archer = new Archer("Legolas");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}