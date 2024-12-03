package school.faang.bjs243800;

public class Archer extends Character {
    private static final int STRANGE = 3;
    private static final int AGILITY = 10;
    private static final int MIND = 5;

    public Archer(String name) {
        super(name, STRANGE, AGILITY, MIND);
    }

    protected void attack(Character character) {
        System.out.println("Персонаж " + character.getName() + " наносит урон персонажу "
                + this.getName() + " урон в размере " + character.getAgility());
        setHealth(this.getHealth() - character.getAgility());
        System.out.println("Уровень здоровья персонажа " + this.getName() +  " = " + this.getHealth());
    }
}
