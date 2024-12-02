package school.faang.sprint_1.task_BJS2_43805;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Tor");
        Archer archer = new Archer("Loki");
        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("Tor: " + warrior.health);
        System.out.println("Loki: " + archer.health);
    }
}
