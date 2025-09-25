package school.faang.bjs2_89699;

import java.util.List;

public class King {
    public static void main(String[] args) {
        Knight firstKnight = new Knight("Сэр Ланселот");
        Knight secondKnight = new Knight("Сэр Галахад");

        List<String> trials = List.of("Джостинг", "Конный мелé", "Пешие бои", "Демонстрация навыков");

        for (String trialName : trials) {
            Trial trialFirstKnight = new Trial(firstKnight.getName(), trialName);
            Trial trialSecondKnight = new Trial(secondKnight.getName(), trialName);

            firstKnight.addTrial(trialFirstKnight);
            secondKnight.addTrial(trialSecondKnight);
        }

        firstKnight.startTrials();
        secondKnight.startTrials();
    }
}
