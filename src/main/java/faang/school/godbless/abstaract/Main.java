package faang.school.godbless.abstaract;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("W_1");
        Archer archer1 = new Archer("A_1");

        System.out.println("Здоровье до боя W_1: " + warrior1.health);
        System.out.println("Здоровье до боя A_1: " + archer1.health);

        warrior1.attack(archer1);
        archer1.attack(warrior1);

        System.out.println("Здоровье после боя W_1: " + warrior1.health);
        System.out.println("Здоровье после боя A_1: " + archer1.health);
    }
}
