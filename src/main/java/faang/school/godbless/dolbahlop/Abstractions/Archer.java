package faang.school.godbless.dolbahlop.Abstractions;

public class Archer extends Character{

    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;
    public Archer(String name){
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE );
    }
    @Override
    public void attack(Character enemy) {
        int damage = calculateDamage();
        enemy.setVitality(enemy.getVitality() - damage);
    }

    //Урон для лучника, равный его ловкости
    private int calculateDamage() {
        return this.agility;
    }

}
