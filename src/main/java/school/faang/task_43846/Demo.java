package school.faang.task_43846;

public class Demo {
    public static void main(String[] args) {

        Character warrior = new Warrior("John");
        Character archer = new Archer("Arton");

        archer.displayInfo();
        warrior.displayInfo();

        warrior.attack(archer);
        archer.attack(warrior);

        warrior.displayInfo();
        archer.displayInfo();
    }
}
