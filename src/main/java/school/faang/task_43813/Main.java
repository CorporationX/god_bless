package school.faang.task_43813;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Vasya");
        Character archer = new Archer("Durak");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
