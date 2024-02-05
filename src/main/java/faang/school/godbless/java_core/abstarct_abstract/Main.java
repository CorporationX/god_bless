package faang.school.godbless.java_core.abstarct_abstract;

public class Main {
    public static void main(String[] args) {
        Character warrior1 = new Warrior("warrior_1");
        Character archer1 = new Archer("archer_1");

        warrior1.attack(archer1);
        archer1.attack(warrior1);

        System.out.println(warrior1);
        System.out.println(archer1);
    }
}
