package school.faang;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Vlad", 12, 10, 3);
        Archer archer = new Archer("Petya", 8, 5, 10);

        warrior.attack(archer);
        archer.attack(warrior);
    }

}
