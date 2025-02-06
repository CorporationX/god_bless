package school.faang;

public class Archer extends Character {
    public static final int DEFAULT_STRENGTH = 3;
    public static final int DEFAULT_AGILITY = 10;
    public static final int DEFAULT_INTELLIGENCE = 5;

    private final StringBuilder hpProgress = new StringBuilder();

    public Archer(String name) {
        super(name);
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    /**
     * Метод наносит урон = ловкости
     *
     * @param opponent - экземпляр класса оппонента
     */
    @Override
    public void attack(Character opponent) {
        if (opponent.getHealth() > 0) {
            opponent.setHealth(opponent.getHealth() - this.agility);
            if (opponent.getHealth() < this.agility) {
                hpProgress.append(opponent.getName())
                        .append(" HP: ")
                        .append(opponent.getHealth())
                        .append("\n");
                opponent.setHealth(0);
            }
            hpProgress.append(opponent.getName())
                    .append(" HP: ").append(opponent.getHealth())
                    .append("\n");
            System.out.println(hpProgress);
        }
        System.out.println(opponent.getName() + " <----- was attacked <------<--- " + this.getName() + "\n");
    }
}
