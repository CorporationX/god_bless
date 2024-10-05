package Abstraction_BJS2_31397;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;


    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void damage (int damage){
    this.health -= damage;
    if (health <0){
        health = 0;
    }
    }
}

    class Warrior extends Character {

        Warrior(String name) {
            super(name, 10, 5, 3);
        }
        @Override
        public void attack (Character opponent){
            System.out.println(this.name + " attack " + opponent.getName() + " with power " + this.power);
            opponent.damage(this.power);
            System.out.println(opponent.getName() + " left health = " + opponent.getHealth());

        }

    }

    class Archer extends Character {
        Archer(String name) {
            super(name, 3, 10, 5);
    }
    @Override
        public void attack (Character opponent) {
        System.out.println(this.name + " attack " + opponent.getName() + " with dexterity " + this.dexterity );
        opponent.damage(this.dexterity);
        System.out.println(opponent.getName() + " left health = " + opponent.getHealth());
    }


}