package ru.kraiush.BJS2_18953;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class App_abstraction_twice {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("JHohn");

        Archer archer = new Archer("Rob");

        System.out.println("warrior: " + warrior);
        archer.attack(warrior);
        System.out.println("warrier after attack by archer:");
        System.out.println("warrior: " + warrior);

        System.out.println("\narcher: " + archer);
        warrior.attack(archer);
        System.out.println("archer after attack by warrier:");
        System.out.println("archer: " + archer);
    }
}
@Getter @Setter @ToString
abstract class Character {

    public String name;
    private int might;
    private int lovcost;
    private int intelligence;
    public int health = 77;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int might, int lovcost, int intelligence) {
        this.name = name;
        this.might = might;
        this.lovcost = lovcost;
        this.intelligence = intelligence;
    }
    abstract void attack(Character character);
}

@Getter
class Warrior extends Character {

    String name;
    int might = 20;
    int lovcost = 5;
    int intelligence = 3;
    int health= super.health;

    public Warrior(String name) {
        super(name);
        this.name=name;
    }

    public Warrior(String name, int might, int lovcost, int intelligence) {
        super(name, might, lovcost, intelligence);
        this.name=name;
        this.might=might;
        this.lovcost=lovcost;
        this.intelligence= intelligence;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.might);;
    }
}

@Getter
class Archer extends Character{

    String name;
     int might = 3;
     int lovcost = 15;
     int intelligence = 5;
     int health= super.health;

    public Archer(String name) {
        super(name);
        this.name=name;
    }

    public Archer(String name, int might, int lovcost, int intelligence) {
        super(name, might, lovcost, intelligence);
        this.name=name;
        this.might=might;
        this.lovcost=lovcost;
        this.intelligence= intelligence;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.lovcost);
    }
}


