package AbstractionAbstraction;

public class Main {
    public static void main(String[] args) {
        Warrior player1 = new Warrior( "Inna");
        Archer player2 = new Archer("Irina");
        player1.attack(player2);
        player2.attack(player1);
        System.out.println(player1.getHealth());
        System.out.println(player2.getHealth());
    }
}
