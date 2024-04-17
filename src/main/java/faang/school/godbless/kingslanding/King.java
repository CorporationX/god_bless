package faang.school.godbless.kingslanding;

import java.util.ArrayList;
import java.util.List;

public class King {
    public static void main(String[] args) {
        List<Knight> knights = new ArrayList<>();
        Knight knight1 = new Knight("Tyrion Lannister");
        Knight knight2 = new Knight("Robb Stark");

        knight1.addTrial(new Trial("Tyrion Lannister", "Trash talk"));
        knight1.addTrial(new Trial("Tyrion Lannister", "Drinking"));
        knight2.addTrial(new Trial("Robb Stark", "Fight for throne"));
        knight2.addTrial(new Trial("Robb Stark", "Wedding"));

        knights.add(knight1);
        knights.add(knight2);

        for (Knight knight : knights) {
            knight.startTrials();
        }
    }
}
