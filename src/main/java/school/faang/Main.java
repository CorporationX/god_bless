package school.faang;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        System.out.printf("Параметры варвара: %s \n", warrior);
        System.out.printf("Параметры лучника: %s \n", archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
