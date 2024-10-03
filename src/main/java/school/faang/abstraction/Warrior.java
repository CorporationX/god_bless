package school.faang.abstraction;

public class Warrior extends Character {
    protected Integer health = 100;
    public Warrior(String name) {
        super (name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        System.out.println("Warrior нанес: " + Warrior.this.power + " поинтов урона");
        System.out.println("У противника теперь: " + (character.getHealth() - Warrior.this.power) + " очков здоровья");
        character.setHealth(character.getHealth() - Warrior.this.power);
    }
}
