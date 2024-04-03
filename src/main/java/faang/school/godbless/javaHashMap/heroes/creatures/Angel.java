package faang.school.godbless.javaHashMap.heroes.creatures;

public class Angel extends Creature {
    public Angel(String name, int quantity) {
        this.setName(name);
        this.setLvl(5);
        this.setHp(10);
        this.setAttack(100);
        this.setDefence(0);
        this.setSpeed(20);
        this.setQuantity(quantity);
    }
}
