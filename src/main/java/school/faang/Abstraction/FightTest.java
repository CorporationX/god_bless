package school.faang.Abstraction;

public class FightTest {
    public static void main(String[] args) {
        Character userOne = new Warrior("bob");
        Character userTwo = new Archer("Jo");
        Character userNoFight = new Character("Tom", 12, 20, 8) {
            @Override
            public void attack(Character opponent) {
                opponent.setHealPoint(opponent.getHealPoint() - getIntelligence());
            }
        };
        System.out.println(userOne);
        userOne.attack(userTwo);
        userOne.attack(userTwo);
        userOne.attack(userTwo);
        userOne.attack(userTwo);
        userTwo.attack(userOne);
        System.out.println(userOne);
        System.out.println(userTwo);
        System.out.println(userNoFight);
    }
}
