package faang.school.godbless.bjs2_18624;

public class Main {
    public static void main(String[] args) {
        var warrior = new Warrior("w");
        var archer = new Archer("a");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("Health after battle:");
        System.out.println("Warrior: " + warrior.getHealth());
        System.out.println("Archer: " + archer.getHealth());
    }
}
