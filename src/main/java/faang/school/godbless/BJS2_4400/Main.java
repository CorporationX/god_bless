package faang.school.godbless.BJS2_4400;

public class Main {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Stan");
        Archer archer = new Archer("Kyle");

        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);

        System.out.println(warrior.getHealth() + " " + archer.getHealth());
    }
}
