package faang.school.godbless.javaHashMap.heroes.creatures;

public class Griffin extends Creature {
    public Griffin(String name) {
        this.setName(name);
        this.setLvl(3);
        this.setManaCost(100);
        this.setAttack(30);
        this.setDefence(50);
        this.setSpeed(10);
    }
}
