package school.faang.bjs2_31343;

public class Main {

    public static void main(String[] args) {
        Character archer = new Archer("Леголас");
        Character warrior = new Warrior("Гимли");

        archer.attack(warrior);
        System.out.println(warrior.health);
        System.out.println(warrior.getName());
    }
}
