package school.faang.tasks_43811.dota2;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int heatPoint = 100;

    public Character(String name) {
        this.name = name;
    }

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


    public void takeDamage(int damage) {
        if (damage < 0) return;
        this.heatPoint -= damage;
        if (this.heatPoint <= 0) {
            this.heatPoint = 0;
            System.out.println(name + " убит");
        }
    }

    public void useDamage(Character target, int damage) {
        if (this.heatPoint <= 0) {
            System.out.println(getName() + " мёртв");
            return;
        }
        if (target.getHeatPoint() <= 0) {
            System.out.println(target.getName() + " не может атаковать");
            return;
        }
        target.takeDamage(damage);
        System.out.println(
                getName() + " атакует " + target.getName()
                        + " и наносит " + damage
                        + " урона. Осталось " + target.getHeatPoint()
                        + " здоровья."
        );
    }

    public void attack(Character target) {
        attacksHero(target);
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
