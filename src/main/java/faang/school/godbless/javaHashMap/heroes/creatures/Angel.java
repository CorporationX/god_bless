package faang.school.godbless.javaHashMap.heroes.creatures;

public class Angel extends Creature {
    public Angel(String name) {
        this.setName(name);
        this.setLvl(5);
        this.setManaCost(150);
        this.setAttack(100);
        this.setDefence(1);
        this.setSpeed(20);
    }
}
