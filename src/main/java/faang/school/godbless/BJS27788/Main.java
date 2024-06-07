package faang.school.godbless.BJS27788;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Viet");
        Archer archer = new Archer("Kani");

        warrior.attack(archer);
        System.out.println(archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getHealth());
    }
}
