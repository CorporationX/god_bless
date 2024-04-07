package faang.school.godbless.BJS2_4582;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);
        System.out.println("Здоровье Archer поcле атаки: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println("Здоровье Warrior поcле атаки: " + warrior.getHealth());
    }
}
