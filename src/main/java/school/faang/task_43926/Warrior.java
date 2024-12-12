package school.faang.task_43926;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        this.setHealth(this.getHealth() - character.getPower());
    }
}
