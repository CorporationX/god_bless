package abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
        System.out.println("Лучник атакует персонажа '"+ character.name + "'");
        System.out.println("Нанесённый урон="+ this.agility);
        System.out.println("У персонажа '" + character.name + "' осталось " + character.health + " здоровья");
    }
}
