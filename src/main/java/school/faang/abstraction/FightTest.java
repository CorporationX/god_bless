package school.faang.abstraction;

public class FightTest {
    public static void main(String[] args) {
        Character userOne = new Warrior("bob");
        Character userTwo = new Archer("Jo");

        System.out.println(userOne);
        userOne.attack(userTwo);
        userOne.attack(userTwo);
        userOne.attack(userTwo);
        userOne.attack(userTwo);
        userTwo.attack(userOne);
        System.out.println(userOne);
        System.out.println(userTwo);

    }
}
