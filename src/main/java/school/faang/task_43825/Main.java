package school.faang.task_43825;

public class Main {

    public static void main(String[] args) {
        Archer archer = new Archer("Robin");
        Warrior warrior = new Warrior("Artur");

        archer.setName("Robin Hood");

        System.out.println(archer);
        System.out.println(warrior);

        System.out.println();

        archer.attack(warrior);
        System.out.println(archer);
        System.out.println(warrior);

        System.out.println();

        warrior.attack(archer);
        System.out.println(archer);
        System.out.println(warrior);
    }

}
