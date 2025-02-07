package school.faang.BJS2_58634;

public class Warrior extends Character {
    private static final int STRINGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGANCE = 3;

    public Warrior(String name) {
        super(name, STRINGTH, AGILITY, INTELLIGANCE);
    }

    @Override
    public void attack(Character opponent) {
        while (opponent.getHp() > 0) {
            opponent.setHp(opponent.getHp() - this.getStrength()); // Уменьшаем HP оппонента
            System.out.println(opponent.getName() + " имеет " + opponent.getHp() + " HP");
            if (opponent.getHp() <= 0) {
                System.out.println("Враг " + opponent.getName() + " повержен!");
                break;
            }
        }
    }
}
