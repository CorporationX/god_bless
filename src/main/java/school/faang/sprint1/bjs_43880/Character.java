package school.faang.sprint1.bjs_43880;

import java.util.Scanner;

public abstract class Character {
    protected static final Scanner SCANNER = new Scanner(System.in);

    protected String name;
    protected int force;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    Character(String name) {
        this.name = name;
    }

    Character(int force, int dexterity, int intelligence) {
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void setName() {
        System.out.println("Введите имя персонажа: ");
        this.name = SCANNER.nextLine();
    }

    public abstract void attack(Character character);
}
