package faang.school.godbless.BJS218658;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Rick");
        Warrior warrior = new Warrior("Pig");

        System.out.println(archer.getName() + ": " + archer.getHp() + " "  + warrior.getName() + ": " + warrior.getHp());

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println(archer.getName() + ": " + archer.getHp() + " "  + warrior.getName() + ": " + warrior.getHp());
    }
}