package school.faang.bjs2_92600;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("Игорь");
        Player secondPlayer = new Player("Виктор");
        Quest firstQuest = new Quest("Помоги другу", 2, 30);
        Quest secondQuest = new Quest("Разгроми армию врага", 7, 100);
        QuestSystem questSystem = new QuestSystem();

        questSystem.startQuest(firstPlayer, firstQuest)
                .thenAccept(player -> log.info("{} имеет {} опыта", player.getName(), player.getExperience()));
        questSystem.startQuest(firstPlayer, secondQuest)
                .thenAccept(player -> log.info("{} имеет {} опыта", player.getName(), player.getExperience()));
        questSystem.startQuest(secondPlayer, firstQuest)
                .thenAccept(player -> log.info("{} имеет {} опыта", player.getName(), player.getExperience()));
        questSystem.startQuest(secondPlayer, secondQuest)
                .thenAccept(player -> log.info("{} имеет {} опыта", player.getName(), player.getExperience()));

        questSystem.shutdownCorrectly();
    }
}
