package school.faang.tasks_43811.dota2;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int heatPoint = 100;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHeatPoint() {
        return heatPoint;
    }

    public boolean isAlive() {
        return heatPoint > 0;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            return;
        }
        this.heatPoint = Math.max(this.heatPoint - damage, 0);
        if (!isAlive()) {
            System.out.println(name + " только что убит.");
        }
    }

    public void useDamage(Character target, int damage) {
        if (!isAlive()) {
            System.out.println(getName() + " мёртв и не может атаковать!");
            return;
        }
        if (!target.isAlive()) {
            System.out.println(target.getName() + " нельзя атаковать поскольку он убит!");
            return;
        }

        target.takeDamage(damage);
        System.out.println(
                getName() + " атакует " + target.getName()
                        + " и наносит " + damage
                        + " урона. У " + target.getName()
                        + " осталось " + target.getHeatPoint()
                        + " здоровья."
        );
    }

    protected abstract void attacksHero(Character target);

    @Override
    public String toString() {
        return "Character{"
                + "name='" + name + '\''
                + ", heatPoint=" + heatPoint
                + ", strength=" + strength
                + ", agility=" + agility
                + ", intelligence=" + intelligence
                + '}';
    }
}
