package school.faang;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
