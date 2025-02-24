package school.faang.task_43901;

public class Warrior extends Character {


    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        this.health -= character.getPower();
    }

    public String toString() {
        return "Warrior:" + " name='" + name + '\'' + ", power=" + power + ", dexterity=" + dexterity
                + ", intelligence=" + intelligence + ", health=" + health + '}';
    }
}
