package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.health -= super.power;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}