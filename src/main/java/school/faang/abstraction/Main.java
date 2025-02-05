package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Виктор");
        Character warrior = new Warrior("Тим");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("После боя!");
        showCharacteristics(warrior);
        showCharacteristics(archer);
    }

    public static void showCharacteristics(Character character) {
        System.out.println(character);
        System.out.println();
    }
}

