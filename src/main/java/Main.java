import faang.school.godbless.Abstraction.model.Archer;
import faang.school.godbless.Abstraction.model.Character;
import faang.school.godbless.Abstraction.model.Warrior;
import faang.school.godbless.groupUsers.model.User;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Alderheart");
        Archer archer = new Archer("Artemis");
        archer.attack(warrior);
        warrior.attack(archer);
    }
}
