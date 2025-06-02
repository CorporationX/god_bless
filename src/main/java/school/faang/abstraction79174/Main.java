package school.faang.abstraction79174;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Voin");
        Archer archer = new Archer("archer");
        SuperBoss boss = new SuperBoss("Ogr", 123, 45, 1);

        warrior.attack(archer);
        System.out.println(archer.getHealth());

        warrior.attack(boss);
        boss.attack(warrior);
    }
}
