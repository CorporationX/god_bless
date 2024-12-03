package school.faang.bjs243800;

public class Warrior extends Character {
    private static final int STRANGE = 10;
    private static final int AGILITY = 5;
    private static final int MIND = 3;

    public Warrior(String name) {
        super(name, STRANGE, AGILITY, MIND);
    }

    @Override
    protected void attack(Character character) {
        System.out.println("Персонаж " + character.getName() + " наносит урон персонажу "
                + this.getName() + " в размере " + character.getStrange());
        setHealth(this.getHealth() - character.getStrange());
        System.out.println("Уровень здоровья персонажа " + this.getName() + " = " + this.getHealth());
    }
}
