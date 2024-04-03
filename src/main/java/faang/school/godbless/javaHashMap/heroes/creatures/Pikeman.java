package faang.school.godbless.javaHashMap.heroes.creatures;


public class Pikeman extends Creature {
    public Pikeman(String name, int quantity) {
        this.setName(name);
        this.setLvl(0);
        this.setHp(20);
        this.setAttack(10);
        this.setDefence(5);
        this.setSpeed(6);
        this.setQuantity(quantity);
    }
}
