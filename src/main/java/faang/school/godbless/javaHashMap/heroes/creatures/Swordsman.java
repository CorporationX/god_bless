package faang.school.godbless.javaHashMap.heroes.creatures;

public class Swordsman extends Creature {
    public Swordsman(String name, int quantity) {
        this.setName(name);
        this.setLvl(0);
        this.setHp(25);
        this.setAttack(10);
        this.setDefence(7);
        this.setSpeed(10);
        this.setQuantity(quantity);
    }
}
