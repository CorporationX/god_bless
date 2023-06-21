package faang.school.godbless.kxnvg.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.health - this.strength);
        if (character.health > 0) {
            System.out.println(this.name + " нанес " + this.strength + " едениц урона " + character.name);
            System.out.println("У " + character.name + " осталось " + character.health + " едениц здоровья");
        } else {
            character.setHealth(0);
            System.out.println(character.name + " был убит от руки " + this.name);
        }
    }
}
