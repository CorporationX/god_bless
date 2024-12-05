package school.faang.bjs243816;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Bulbo");
        Archer archer = new Archer("Lagovaz");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        warrior.attack(archer);

        System.out.println(warrior);
        System.out.println(archer);
    }
}