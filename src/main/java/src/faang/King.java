package src.faang;

import src.faang.model.Knight;
import src.faang.model.Trial;

import java.util.List;

import static src.faang.model.TrialType.JUMPING;
import static src.faang.model.TrialType.SQUATS;

public class King {
    private static final String DANIYAL = "Daniyal";
    private static final String LADA = "Lada";

    public static void main(String[] args) {
        final List<Knight> knights = getKnights();
        final List<Trial> trials = getTrials();

        for (Knight knight : knights) {
            for (Trial trial : trials) {
                knight.add(trial);
            }

            knight.startsTrial();
        }
    }

    private static List<Knight> getKnights() {
        return List.of(
                new Knight(DANIYAL),
                new Knight(LADA)
        );
    }

    private static List<Trial> getTrials() {
        return List.of(
                new Trial(DANIYAL, JUMPING.name()),
                new Trial(DANIYAL, SQUATS.name()),
                new Trial(LADA, JUMPING.name()),
                new Trial(LADA, SQUATS.name())
        );
    }
}

