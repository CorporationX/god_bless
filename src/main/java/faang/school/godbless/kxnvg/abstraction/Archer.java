package faang.school.godbless.kxnvg.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name,3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.health - agility);
        if (character.health > 0) {
            System.out.println(this.name + " нанес " + agility + " едениц урона " + character.name);
            System.out.println("У " + character.name + " осталось " + character.health + " едениц здоровья");
        } else {
            character.setHealth(0);
            System.out.println(character.name + " был убит от руки " + this.name);
        }
    }
}
