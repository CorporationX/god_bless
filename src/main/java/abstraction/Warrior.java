package abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
        System.out.println("Воин атакует персонажа '"+ character.name + "'");
        System.out.println("Нанесённый урон="+ this.power);
        System.out.println("У персонажа '" + character.name + "' осталось "+ character.health + " здоровья");
    }
}
