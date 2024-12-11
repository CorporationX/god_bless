package school.faang.task_43901;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        this.health -= character.getPower();
    }

    @Override
    public String toString() {
        return "Archer:" + " name='" + name + '\'' + ", power=" + power + ", dexterity=" + dexterity
                + ", intelligence=" + intelligence + ", health=" + health + '}';
    }
}
