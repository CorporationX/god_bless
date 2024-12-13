package school.faang.task_43916;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer");
        Warrior warrior = new Warrior("Warrior");

        System.out.println("Befor Archer health: " + archer.health);
        System.out.println("Befor Warrior health: " + warrior.health);


        System.out.println("Fighting!");
        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("After Archer health: " + archer.health);
        System.out.println("After Warrior health: " + warrior.health);

    }
}
