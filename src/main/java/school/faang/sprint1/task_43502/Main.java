package school.faang.sprint1.task_43502;

public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("Axe");
        Character archer = new Archer("Mirana");

        System.out.println("Warrior ===> " + warrior);
        System.out.println("Archer ===> " + archer);

        warrior.attack(archer);
        System.out.println("Archer ===> " + archer);

        archer.attack(warrior);
        System.out.println("Warrior ===> " + warrior);
    }
}
