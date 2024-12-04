package school.faang.sprint1.task_43819;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("warrior");
        Archer archer = new Archer("archer");

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println(archer.getHealth());
        System.out.println(warrior.getHealth());

        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }

        System.out.println(archer.getHealth());

    }
}
