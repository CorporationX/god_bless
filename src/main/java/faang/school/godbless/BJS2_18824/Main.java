package faang.school.godbless.BJS2_18824;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Ruslan");
        Warrior warrior = new Warrior("Darina");

        System.out.println(warrior.health);
        archer.attack(warrior);
        System.out.println(warrior.health);
    }
}
