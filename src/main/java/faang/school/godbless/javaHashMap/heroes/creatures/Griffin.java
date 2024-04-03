package faang.school.godbless.javaHashMap.heroes.creatures;

public class Griffin extends Creature {
    public Griffin(String name, int quantity) {
        this.setName(name);
        this.setLvl(3);
        this.setHp(100);
        this.setAttack(20);
        this.setDefence(15);
        this.setSpeed(10);
        this.setQuantity(quantity);
    }
}
