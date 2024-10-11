package abstraction.abstraction;

public class Fighting {
    public static void main(String[] args) {
        int variable = 0;
        Warrior warrior = new Warrior("Ivan", variable, variable, variable);
        Archer archer = new Archer("Nik", variable, variable, variable);
        warrior.attack(archer);
        archer.attack(warrior);
    }
}