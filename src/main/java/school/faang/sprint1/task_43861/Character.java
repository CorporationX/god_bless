package school.faang.sprint1.task_43861;

abstract class Character {
    protected String name;
    protected long strength;
    protected long agility;
    protected long intelligence;
    protected long health = 100;


    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, long strength, long agility, long intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected final void consumeDamage(long damage) {
        health -= damage;
        if (health <= 0) {
            System.out.printf(
                    "character: %s: %s lost",
                    getClass().getSimpleName(),
                    name
            );
            throw new IllegalArgumentException("game over");
        }
    }

    abstract void attack(Character character);
}
