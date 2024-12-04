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
        if (this.getHealth() > 0) {
            if (this.getStrange() > character.getHealth()) {
                System.out.println("Наносимый урон персонажа " + this.getName() + " больше уровня жизней персонажа "
                        + character.getName() + ". Атакуемый персонаж убит.");
                character.setHealth(0);
                System.out.println("Уровень жизни персонажа " + character.getName()
                        + " = " + character.getHealth());
            } else {
                System.out.println("Персонаж " + this.getName() + " наносит урон персонажу "
                        + character.getName() + " в размере " + this.getStrange());
                dealingDamadge(character, this.getStrange());
                System.out.println("Уровень здоровья персонажа " + character.getName() + " = " + character.getHealth());
            }
        } else {
            System.out.println("Персонаж " + this.getName() + " мертв и не может наносить атак.");
        }
    }
}
