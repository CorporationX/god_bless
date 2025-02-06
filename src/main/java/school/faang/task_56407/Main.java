package school.faang.task_56407;

public class Main {
    public static void main(String[] args) {

        Character warrior = new Warrior("Конан");
        Character archer = new Archer("Леголас");

        System.out.println(archer.getHealth());
        warrior.attack(archer);
        System.out.println(archer.getHealth());



    }
}
