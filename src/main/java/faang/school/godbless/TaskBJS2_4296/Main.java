package faang.school.godbless.TaskBJS2_4296;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Jack");
        Archer archer = new Archer("Bob");

        System.out.printf("Здоровье воина: %d %n", warrior.health);
        System.out.printf("Здоровье лучника: %d %n", archer.health);

        System.out.println("---------------------------");
        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("---------------------------");
        System.out.printf("Здоровье после боя воина: %d %n", warrior.health);
        System.out.printf("Здоровье после боя лучника: %d %n", archer.health);

    }
}
