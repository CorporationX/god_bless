package school.faang.task_43884;

public class Main {

    public static void main(String[] args) {
        Character archer = new Archer("Salmon");
        Character warrior = new Warrior("Axe");

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("Warrior health is " + warrior.getHealth());
        System.out.println("Archer health is " + archer.getHealth());
    }
}