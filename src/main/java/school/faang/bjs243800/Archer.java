package school.faang.bjs243800;

public class Archer extends Character {
    private static final int STRANGE = 3;
    private static final int AGILITY = 10;
    private static final int MIND = 5;

    public Archer(String name) {
        super(name, STRANGE, AGILITY, MIND);
    }

    protected void attack(Character character) {
        if (this.getHealth() > 0) {
            if (this.getAgility() > character.getHealth()) {
                System.out.println("Наносимый урон персонажа " + this.getName() + " больше уровня жизней персонажа "
                        + character.getName() + ". Атакуемый персонаж убит.");
                character.setHealth(0);
                System.out.println("Уровень жизни персонажа " + character.getName()
                        + " = " + character.getHealth());
            } else {
                System.out.println("Персонаж " + this.getName() + " наносит урон персонажу "
                        + character.getName() + " в размере " + this.getAgility());
                dealingDamadge(character, this.getAgility());
                System.out.println("Уровень здоровья персонажа " + character.getName() + " = " + character.getHealth());
            }
        } else {
            System.out.println("Персонаж " + this.getName() + " мертв и не может наносить атак.");
        }
    }
}
