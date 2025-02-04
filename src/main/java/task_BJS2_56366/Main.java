package task_BJS2_56366;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Anton");
        System.out.println(archer);

        Warrior warrior = new Warrior("Bob");
        System.out.println(warrior);

        archer.attack(warrior);
        System.out.println(warrior);

        warrior.attack(archer);
        System.out.println(archer);


        Archer archer1 = new Archer("Sam", 10, 20, 30);
        System.out.println(archer1);

        Warrior warrior1 = new Warrior("Elis", 30, 7, 1);
        System.out.println(warrior1);

        archer1.attack(warrior1);
        System.out.println(warrior1);

        warrior1.attack(archer1);
        System.out.println(archer1);
    }
}
