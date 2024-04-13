package faang.school.godbless.hashMap.task_7.model.creatures;

public abstract class Creature {
    private final String name;
    private final int level;
    private int health;
    private int damage;
    private int defence;
    private int quantity;
    private int squadHealth;

    protected Creature(String name, int level, int health, int damage, int defence) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSquadHealth() {
        return squadHealth;
    }

    public int attack(Creature creature) {
        int damageOfOneCreature = damage - creature.getDefence();
        if (damageOfOneCreature <= 0) {
            damageOfOneCreature = 1;
        }
        int damageOfSquad = damageOfOneCreature * quantity;
        int squadSize = creature.getQuantity();
        int killedCreatures = creature.decreaseHealthAndCountKilledUnits(damageOfSquad);
        if (killedCreatures > squadSize) {
            killedCreatures = squadSize;
        }
        System.out.println("отряд " + name + " нанес " + damageOfSquad + " единиц урона отряду " + creature.name + " погибло " + killedCreatures);
        return killedCreatures;
    }

    private int decreaseHealthAndCountKilledUnits(int damage) {
        squadHealth -= damage;
        return damage / health;
    }



    public void increaseQuantity(int numberOfAddingCreatures) {
        quantity += numberOfAddingCreatures;
        squadHealth = quantity * health;
    }

    public int decreaseQuantity(int numberOfSubtractingCreatures) {
        quantity = numberOfSubtractingCreatures > quantity ? 0 : quantity - numberOfSubtractingCreatures;
        return quantity;
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}