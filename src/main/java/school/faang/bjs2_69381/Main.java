package school.faang.bjs2_69381;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Чел1");
        Character archer = new Archer("Чел2");
        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);

        System.out.println(warrior.health);
        System.out.println(archer.health);
    }
}