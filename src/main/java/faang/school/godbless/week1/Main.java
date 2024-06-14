package faang.school.godbless.week1;

public class Main {
    //Use of characters
    public static void main(String[] args) {
        //Creat chars
        Character warrior = new Warrior("Aragorn");
        Character archer = new Archer("Legolas");
        // test attacks
        warrior.attack(archer);
        archer.attack(warrior);
        // How much health left
        System.out.println(warrior.getName() + " has " + warrior.getHealth() + " health left. ");
        System.out.println(archer.getName() + " has " + archer.getHealth() + " health left ");
    }
}
