package faang.school.godbless.BJS2_7755;

public class Main {
    public static void main(String[] args) {
        Character archer1 = new Archer("Archer1Name");
        Character archer2 = new Archer("Archer2Name", 10, 10, 10);
        System.out.println(archer1);
        System.out.println(archer2);
        Character warrior1 = new Warrior("Warrior1Name");
        Character warrior2 = new Warrior("Warrior2Name", 10, 10, 10);
        System.out.println(warrior1);
        System.out.println(warrior2);
        archer1.attack(warrior1);
        System.out.println(warrior1);
        warrior1.attack(archer1);
        System.out.println(archer1);
    }
}
