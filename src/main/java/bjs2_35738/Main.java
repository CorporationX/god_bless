package bjs2_35738;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Chore> chores = List.of(
                new Chore("Wash dishes"),
                new Chore("Make the bed"),
                new Chore("Make dinner"),
                new Chore("Wash floor"),
                new Chore("Wash clothes")
        );

        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
        weasleyFamily.doChores();
    }
}
