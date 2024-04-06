package faang.school.godbless.javaHashMap.heroes.creatures;


public class Pikeman extends Creature {
    public Pikeman(String name) {
        this.setName(name);
        this.setLvl(0);
        this.setManaCost(5);
        this.setAttack(10);
        this.setDefence(5);
        this.setSpeed(6);
    }
}
