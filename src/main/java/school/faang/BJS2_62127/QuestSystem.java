package school.faang.BJS2_62127;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    private static final int NEXT_LEVEL = 100;
    public static final int TIME_LEVEL_EASY = 2000;
    public static final int TIME_LEVEL_MEDIUM = 3000;
    public static final int TIME_LEVEL_HARD = 4000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        log.info("Начинаем выполнение квеста для игрока: {}", player.getName());
                        Thread.sleep(sleepTime(quest));
                    } catch (InterruptedException e) {
                        log.error("Ошибка: Прерывание потока при выполнении квеста для игрока: {}",
                                player.getName(), e);
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    return player;
                })
                .thenApply(p -> updatePlayerExperienceAndLevel(p, quest));
    }

    public long sleepTime(Quest quest) {
        return switch (quest.getDifficulty()) {
            case EASY -> TIME_LEVEL_EASY;
            case MEDIUM -> TIME_LEVEL_MEDIUM;
            case HARD -> TIME_LEVEL_HARD;
        };
    }

    public synchronized Player updatePlayerExperienceAndLevel(Player player, Quest quest) {
        int currentExperience = player.getExperience() + quest.getReward();
        if (currentExperience >= NEXT_LEVEL) {
            int newExperience = currentExperience - NEXT_LEVEL;
            player.setLevel(player.getLevel() + 1);
            player.setExperience(newExperience);
            log.info("Игрок {} повысил уровень до {} с новым опытом {}",
                    player.getName(), player.getLevel(), newExperience);
        } else {
            player.setExperience(currentExperience);
            log.info("Игрок {} обновил опыт, текущий опыт: {}", player.getName(), currentExperience);
        }
        return player;
    }
}
