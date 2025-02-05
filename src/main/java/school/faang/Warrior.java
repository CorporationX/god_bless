package school.faang;


public class Warrior extends Character {
    public static final int DEFAULT_STRENGTH = 10;
    public static final  int DEFAULT_AGILITY = 5;
    public static final  int DEFAULT_INTELLIGENCE = 3;

    private final StringBuilder hpProgress = new StringBuilder();

    public Warrior(String name) {
        super(name);
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }
    /**
     * Метод наносит урон = силе
     *
     * @param opponent - экземпляр класса оппонента
     */

    @Override
    public void attack(Character opponent) {
        if (opponent.getHealth() > 0) {
            do {
                opponent.setHealth(opponent.getHealth() - this.strength);
                hpProgress.append(opponent.getName())
                        .append(" HP: ")
                        .append(opponent.getHealth())
                        .append("\n");
                if (opponent.getHealth() < this.strength) {
                    opponent.setHealth(0);
                }
            } while (opponent.getHealth() > 0);
            hpProgress.append(opponent.getName())
                    .append(" HP: ").append(opponent.getHealth())
                    .append("\n");
            System.out.println(hpProgress);
        }
        System.out.println(opponent.getName() + " <----- was attacked <------<--- " + this.getName() + "\n");
    }
}
