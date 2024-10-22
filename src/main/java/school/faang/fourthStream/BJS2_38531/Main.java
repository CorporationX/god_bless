package school.faang.fourthStream.BJS2_38531;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player(faker.leagueOfLegends().champion(), 10, 250);
        Player player2 = new Player(faker.leagueOfLegends().champion(), 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 11, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        questSystem.startQuest(player1, quest1);
        questSystem.startQuest(player2, quest2);

        questSystem.shutdownService();
    }
}
