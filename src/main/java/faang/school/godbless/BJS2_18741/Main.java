package faang.school.godbless.BJS2_18741;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Arman");
        Archer archer = new Archer("Suragan");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior.getHealth());
        System.out.println(archer.getHealth());
    }
}
