package school.faang.rpg;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Солдат");
        Character archer = new Archer("Лучник");
        System.out.println(warrior);
        System.out.println(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior);
        System.out.println(archer);
    }
}
