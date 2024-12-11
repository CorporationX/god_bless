package school.faang.task_43901;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer");
        Warrior warrior = new Warrior("Warrior");
        System.out.println("Было");
        System.out.println(archer);
        System.out.println(warrior);

        System.out.println("Атака archer на warrior");
        warrior.attack(archer);
        System.out.println(archer);
        System.out.println(warrior);

        System.out.println("Атака warrior на archer");
        archer.attack(warrior);
        System.out.println(archer);
        System.out.println(warrior);
    }
}
