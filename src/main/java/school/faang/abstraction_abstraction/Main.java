package school.faang.abstraction_abstraction;

public class Main {

    public static void main(String[] args) {

        var warrior = new Warrior("Warrior");
        var archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("After attack archer has: " + archer.getHp() + "hp");
        System.out.println("After attack warrior has: " + warrior.getHp() + "hp");
    }
}
