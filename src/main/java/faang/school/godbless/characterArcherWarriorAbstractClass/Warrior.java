package faang.school.godbless.characterArcherWarriorAbstractClass;

public class Warrior extends Character {
    private static int NTELLIGENCE = 3;
    private static int DEXTERITY = 5;
    private static int FORCE = 10;

    public Warrior(String name){
        super(name, NTELLIGENCE, DEXTERITY, FORCE);
    }

    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
        int damage = opponent.getHealth() - this.getForce();
        opponent.setHealth(damage);
    }
}
