package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("король");
        Character archer = new Archer("лучник");

        for(int i = 0; i < 11; i++)
            archer.attack(warrior);
        System.out.println(warrior.health);
        warrior.attack(archer);
        System.out.println((archer.health));
    }
}
