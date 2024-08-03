package faang.school.godbless.BJS2_18567;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Hulk");
        Archer archer = new Archer("Ariel");

        Archer enemy1 = new Archer("Enemy1");
        Warrior enemy2 = new Warrior("Enemy2");

        System.out.println(enemy1.getName() + " health before attack " + enemy1.getHealth());
        warrior.attack(enemy1);
        System.out.println(enemy1.getName() + " health after attack " + enemy1.getHealth());

        System.out.println(enemy2.getName() + " health before attack " + enemy2.getHealth());
        archer.attack(enemy2);
        System.out.println(enemy2.getName() + " health after attack " + enemy2.getHealth());
    }
}
