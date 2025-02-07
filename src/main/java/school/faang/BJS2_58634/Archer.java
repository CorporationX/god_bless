package school.faang.BJS2_58634;

public class Archer extends Character {

    private static final int STRINGTH = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGANCE = 5;

    public Archer(String name) {
        super(name, STRINGTH, AGILITY, INTELLIGANCE);

    }


    @Override
    public void attack(Character opponent) {
        while (opponent.getHp() > 0) {
            opponent.setHp(opponent.getHp() - this.getAgility());
            System.out.println(opponent.getName() + " имеет " + opponent.getHp() + " HP");
            if (opponent.getHp() <= 0) {
                System.out.println("Враг " + opponent.getName() + " повержен!");
                break;
            }
        }
    }
}
