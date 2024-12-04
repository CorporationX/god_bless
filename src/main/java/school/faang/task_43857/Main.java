package school.faang.task_43857;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("alex");
        Character archer = new Archer("alexa");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
