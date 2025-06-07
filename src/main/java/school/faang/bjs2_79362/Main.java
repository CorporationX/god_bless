package school.faang.bjs2_79362;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Голиаф");
        Character archer = new Archer("Давид");

        warrior.attack(archer);
        System.out.println(archer.getName() + " здоровье " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " здоровье " + warrior.getHealth());
    }
}
