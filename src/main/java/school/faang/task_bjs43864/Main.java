package school.faang.task_bjs43864;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warior");
        Archer archer = new Archer("archer");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior.getHealth());
        System.out.println(archer.getHealth());
    }
}
