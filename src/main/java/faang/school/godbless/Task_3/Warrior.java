package faang.school.godbless.Task_3;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }

    @Override
    void attack(Character character) {

        System.out.println("Enemy's condition before battle = " + character);
        System.out.println("Warrior's condition before battle = " + this);

        character.health = character.health - this.strength;

        System.out.println("Enemy's condition after battle = " + character);
        System.out.println("Warrior's condition after battle = " + this);

    }
}
