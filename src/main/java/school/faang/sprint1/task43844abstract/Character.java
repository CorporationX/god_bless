package school.faang.sprint1.task43844abstract;

public abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer intelligence;
    protected Integer dexterity;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer intelligence, Integer dexterity) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
    }

    public abstract void attack(Character character);

    protected boolean unacceptableDamage(Character character) {
        if (this == character) {
            System.out.println("Мы не мазохисты!)");
            return true;
        } else if (character.health == 0) {
            System.out.println("Не надо бить труп");
            return true;
        } else {
            return false;
        }
    }
}
