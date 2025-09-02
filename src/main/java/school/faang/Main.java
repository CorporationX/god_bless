package school.faang;

public class Main {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Громила");
        Archer archer = new Archer("Меткий глаз");


        System.out.println("Игра началась!");
        System.out.println(warrior.getName() + " здоровье: " + warrior.getHealth());
        System.out.println(archer.getName() + " здоровье: " + archer.getHealth());


        System.out.println("\nБой начинается!");
        warrior.attack(archer);
        System.out.println(warrior.getName() + " атакует " + archer.getName());
        System.out.println(archer.getName() + " здоровье: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(archer.getName() + " атакует " + warrior.getName());
        System.out.println(warrior.getName() + " здоровье: " + warrior.getHealth());


        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);



        System.out.println("\nИтоги боя:");
        System.out.println(warrior.getName() + " здоровье: " + warrior.getHealth());
        System.out.println(archer.getName() + " здоровье: " + archer.getHealth());
    }

}
