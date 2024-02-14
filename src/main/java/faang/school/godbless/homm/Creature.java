package faang.school.godbless.homm;

import java.util.Objects;

public abstract class Creature {
    private String name;
    private int lavel;
    private int attackPoint;
    private int defancePoin;
    private int speedPoint;
    private int count;

    public Creature(String name, int lavel, int attackPoint, int defancePoin, int speedPoint, int count) {
        this.name = name;
        this.lavel = lavel;
        this.attackPoint = attackPoint;
        this.defancePoin = defancePoin;
        this.speedPoint = speedPoint;
        this.count = count;
    }

    public int getDamage(){
        return attackPoint;
    }

    public int getDefancePoin() {
        return defancePoin;
    }

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", lavel=" + lavel +
                ", attackPoint=" + attackPoint +
                ", defancePoin=" + defancePoin +
                ", speedPoint=" + speedPoint +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Creature creature = (Creature) object;
        return lavel == creature.lavel && attackPoint == creature.attackPoint && defancePoin == creature.defancePoin && speedPoint == creature.speedPoint && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lavel, attackPoint, defancePoin, speedPoint);
    }
}
