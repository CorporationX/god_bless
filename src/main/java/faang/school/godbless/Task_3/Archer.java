package faang.school.godbless.Task_3;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }

    @Override
    void attack(Character character) {

        System.out.println("Enemy's condition before battle = " + character);
        System.out.println("Archer's condition before battle = " + this);

        character.health = character.health - this.agility;

        System.out.println("Enemy's condition after battle = " + character);
        System.out.println("Archer's condition after battle = " + this);

    }
}
