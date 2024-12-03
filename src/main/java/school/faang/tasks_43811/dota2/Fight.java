package school.faang.tasks_43811.dota2;

public class Fight {
    public static void main(String[] args) {
        Archer archer = new Archer("Drow Ranger");
        Warrior warrior = new Warrior("Pudge");
        Wizard wizard = new Wizard("Invoker");

        System.out.println("Начальное здоровье:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());
        System.out.println(wizard.getName() + ": " + wizard.getHeatPoint());

        archer.attacksHero(warrior);
        warrior.attacksHero(archer);
        wizard.attacksHero(archer);

        System.out.println("Здоровье после атак:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());

        archer.attacksHero(warrior);
        warrior.attacksHero(archer);

        System.out.println("Здоровье после атак:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());

        archer.attacksHero(warrior);
        warrior.attacksHero(archer);

        System.out.println("Здоровье после атак:");
        System.out.println(warrior.getName() + ": " + warrior.getHeatPoint());
        System.out.println(archer.getName() + ": " + archer.getHeatPoint());
    }
}