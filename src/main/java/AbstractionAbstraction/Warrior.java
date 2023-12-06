package AbstractionAbstraction;

    public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setDexterity(5);
        setIntelligence(3);
    }

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, 10, 5, 3);
    }

        @Override
        public void attack(Character character) {
                character.setHealth(character.getHealth() - this.getStrength());
        }
    }
