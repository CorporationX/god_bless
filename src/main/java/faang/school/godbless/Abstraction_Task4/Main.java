package faang.school.godbless.Abstraction_Task4;

public class Main {

    public static void main(String[] args) {

        Character war = new Warrior("Thrall");
        System.out.println(war.getHealth());
        Character hunt = new Archer("Hanzo");
        System.out.println(hunt.getHealth());
        war.attack(hunt);
        System.out.println(hunt.getHealth());
        hunt.attack(war);
        System.out.println(war.getHealth());

    }

}
