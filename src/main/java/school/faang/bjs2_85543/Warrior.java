package school.faang.bjs2_85543;

public class Warrior extends Character {

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {

        System.out.printf("Damage caused by %s in size %d by hero %s \n",
                this.getName(), this.getStrength(), opponent.getName());

        opponent.setHealth(opponent.getHealth() - this.getStrength());

        if (opponent.getHealth() <= 0) {
            opponent.setHealth(0);
            System.out.printf("Hero %s is died \n", opponent.getName());
            return;
        }
        System.out.printf("Hero %s have %d hp \n", opponent.getName(), opponent.getHealth());
    }
}
