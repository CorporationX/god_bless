package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {

        Character warrior = new Warrior("Войн");
        Character archer = new Archer("Без смерть");
        warrior.attack(archer);
        archer.attack(warrior);

    }
}
