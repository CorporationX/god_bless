package faang.school.godbless.characterArcherWarriorAbstractClass;

public class Archer extends Character {
    private static int NTELLIGENCE = 5;
    private static int DEXTERITY = 10;
    private static int FORCE = 3;

    public Archer(String name){
        super(name, NTELLIGENCE, DEXTERITY, FORCE);
    }

    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
        int damage = opponent.getHealth() - this.getDexterity();
        opponent.setHealth(damage);
    }
}
