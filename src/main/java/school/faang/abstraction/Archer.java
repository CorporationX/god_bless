package school.faang.abstraction;

public class Archer extends Character {
    protected Integer health = 100;
    public Archer(String name) {
        super(name,3, 10, 5);
    }

    @Override
    void attack(Character character) {
        System.out.println("Archer нанес: " + Archer.this.power + " поинта урона");
        System.out.println("У противника теперь: " + (character.getHealth() - Archer.this.power) + " очков здоровья");
        character.setHealth(character.getHealth() - Archer.this.power);
    }
}
