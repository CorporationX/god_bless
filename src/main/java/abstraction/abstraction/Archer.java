package abstraction.abstraction;

public class Archer extends Character {
    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - character.getDexterity());
        System.out.println("\n" + "Лучник нанес " + character.getDexterity() + " урона противнику " + character.getName());
        System.out.println("У противника осталось " + character.getHealth() + " здоровья");
    }
}