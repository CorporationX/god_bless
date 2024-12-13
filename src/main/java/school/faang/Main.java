package school.faang;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Arch");
        Warrior warrior = new Warrior("War");

        archer.attack(warrior);
        System.out.println(warrior.getHealth());
    }
}
