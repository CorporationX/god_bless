package school.faang.sprint_1.task_bjs243837;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Aragorn");
        Character archer = new Archer("Legolas");

        System.out.println("---before fight---");
        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);

        System.out.println("---after fight---");
        System.out.println(warrior);
        System.out.println(archer);
    }
}
