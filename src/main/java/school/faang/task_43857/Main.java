package school.faang.task_43857;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("alex");
        Character archer = new Archer("alexa");

        Warrior warrior2 = new Warrior("ggg", 2,4,6);
        Archer archer2 = new Archer("mmm", 3,5,8);

        warrior.attack(archer);
        archer.attack(warrior);

        warrior2.attack(archer2);
        archer2.attack(warrior2);
    }
}
