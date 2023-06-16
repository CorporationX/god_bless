package faang.school.godbless;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5 ,3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}
