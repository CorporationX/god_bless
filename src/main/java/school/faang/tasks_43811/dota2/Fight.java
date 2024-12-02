package school.faang.tasks_43811.dota2;

public class Fight {
    public static void main(String[] args) {
        Archer archer = new Archer("Drow Ranger");
        Warrior warrior = new Warrior("Pudge");

        System.out.println("Начальное здоровье:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("Здоровье после атак:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("Здоровье после атак:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("Здоровье после атак:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());
    }
}
