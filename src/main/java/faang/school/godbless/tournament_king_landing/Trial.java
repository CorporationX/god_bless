package faang.school.godbless.tournament_king_landing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println("Knight " + knightName + " is performing trial: " + trialName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
