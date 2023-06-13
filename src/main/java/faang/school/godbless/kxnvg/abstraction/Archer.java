package faang.school.godbless.kxnvg.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name,3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = this.getAgility();

        character.setHealth(character.getHealth() - damage);
        if (character.getHealth() > 0) {
            System.out.println(this.getName() + " нанес " + damage + " едениц урона " + character.getName());
            System.out.println("У " + character.getName() + " осталось " + character.getHealth() + " едениц здоровья");
        } else {
            character.setHealth(0);
            System.out.println(character.getName() + " был убит от руки " + this.getName());
        }
    }
}
