package school.faang.task_43852;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Gerald");
        Character archer = new Archer("Artur");

        warrior.attack(archer);
        archer.attack(warrior);

        Warrior warrior1 = new Warrior("Arnold");
        Archer archer1 = new Archer("Soda");

        warrior1.attack(warrior);
        archer1.attack(archer);

        System.out.println(warrior.getName() + " health is " + warrior.getHealth());
        System.out.println(warrior1.getName() + " health is " + warrior1.getHealth());
        System.out.println(archer.getName() + " health is " + archer.getHealth());
        System.out.println(archer1.getName() + " health is " + archer1.getHealth());
    }
}
