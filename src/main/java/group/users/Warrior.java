package group.users;

public class Warrior extends Character {

    protected Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character character) {
        character.setHealth(character.getHealth() - character.getStrength());
        System.out.println("\n" + "Воин нанес " + character.getStrength() + " урона противнику " + character.getName());
        System.out.println("У противника осталось " + character.getHealth() + " здоровья");
    }
}
