package group.users;

public class Warrior extends Character {
    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - character.getStrength());
        System.out.println("\n" + "Воин нанес " + character.getStrength() + " урона противнику " + character.getName());
        System.out.println("У противника осталось " + character.getHealth() + " здоровья");
    }
}
