package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior john = new Warrior( "John");
        Archer tom = new Archer("Tom");
        Warrior mickle = new Warrior( "Mickle" );
        mickle.attack(john);
        tom.attack(mickle);
        System.out.println(mickle.health);
        System.out.println(john.health);
    }
}
