package school.faang.task_43846;

public class Demo {
    public static void main(String[] args) {

        Character warrior = new Warrior("John");
        Character archer = new Archer("Arton");

        System.out.println(archer);
        System.out.println(warrior);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
