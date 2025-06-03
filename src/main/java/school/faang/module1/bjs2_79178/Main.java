package school.faang.module1.bjs2_79178;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        System.out.println(warrior.getName() + " (Warrior) начальное здоровье: " + warrior.getHealth());
        System.out.println(archer.getName() + " (Archer) начальное здоровье: " + archer.getHealth());

        warrior.attack(archer);
        System.out.println(archer.getName() + " здоровье после атаки: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " здоровье после атаки: " + warrior.getHealth());
    }
}
