package school.faang.workedin_microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Letter> letters = new ArrayList<>();
        int threadsCount = 5;
        int lettersCount = 1000;

        for (int i = 1; i <= lettersCount; i++) {
            letters.add(new Letter(i));
        }
        HashMap<Integer, List<Integer>> partsOfLetters = calculateParts(threadsCount, lettersCount);
        System.out.println("Parts: " + partsOfLetters);

        for (int i = 1; i <= threadsCount; i++) {
            List<Integer> pair = partsOfLetters.get(i);
            int startIndex = pair.get(0);
            int endIndex = pair.get(1);
            SenderRunner senderRunner = new SenderRunner(letters, startIndex, endIndex);
            Thread newThread = new Thread(senderRunner);
            newThread.start();
        }
    }

    private static HashMap<Integer, List<Integer>> calculateParts(int partsCount, int mainCount) {
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        int step = mainCount / partsCount;
        int endIndex = step;

        for (int part = 1; part <= partsCount; part++) {
            int startIndex = endIndex - step + 1;
            if (part == partsCount && mainCount % partsCount != 0) {
                endIndex += mainCount % partsCount;
            }
            List<Integer> pair = new ArrayList<>(List.of(startIndex, endIndex));
            result.put(part, pair);
            endIndex += step;
        }
        return result;
    }
}
