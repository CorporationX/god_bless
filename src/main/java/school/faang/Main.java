package school.faang;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Artur");
        Archer archer = new Archer("Legolas");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(archer);

        archer.attack(warrior);
        System.out.println(warrior);
    }
}