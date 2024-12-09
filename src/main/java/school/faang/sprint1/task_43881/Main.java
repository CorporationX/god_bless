package school.faang.sprint1.task_43881;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Mouse");
        Character archer = new Archer("Cat");
        System.out.println("Health Mouse = " + warrior.getHealth());
        archer.attac(warrior);
        System.out.println("Health after attac = " + warrior.health);
        System.out.println("Health Cat = " + archer.getHealth());
        warrior.attac(archer);
        warrior.attac(archer);
        System.out.println("Health after attac = " + archer.health);
    }
}
