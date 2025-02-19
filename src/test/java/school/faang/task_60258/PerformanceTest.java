package school.faang.task_60258;

import java.util.Arrays;
import java.util.List;

class PerformanceTest {

    public static void main(String[] args) {
        int numTests = 10;
        long totalV0 = 0;
        long totalV1 = 0;
        long totalV2 = 0;

        for (int i = 0; i < numTests; i++) {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            List<String> data = Arrays.asList(
                    // Цитрусовые фрукты
                    "orange", "blood orange", "lemon", "lime", "pomelo",
                    "tangerine", "grapefruit", "mandarin", "kumquat",

                    // Тропические фрукты
                    "banana", "mango", "pineapple", "coconut", "papaya",
                    "passionfruit", "dragonfruit", "durian", "jackfruit",
                    "lychee", "rambutan", "starfruit", "watermelon",

                    // Ягоды
                    "strawberry", "blueberry", "blackberry", "raspberry",
                    "cranberry", "gooseberry", "elderberry", "blackcurrant",
                    "redcurrant", "kiwi", "huckleberry", "salmonberry",

                    // Кожистые фрукты
                    "apple", "pear", "plum", "peach", "nectarine",
                    "apricot", "cherimoya", "quince", "persimmon",
                    "feijoa", "loquat", "medlar", "prune",

                    // Экзотические фрукты
                    "ackee", "atemoya", "cape gooseberry", "carambola",
                    "cupuacu", "damson", "date", "dragon fruit",
                    "emblica", "fig", "guanabana", "horned melon",
                    "ice apple", "jenipapo", "kaffir lime", "langsat",
                    "longan", "mangosteen", "noni", "physalis",
                    "pomegranate", "rose apple", "soursop", "tamarillo"
            );

            // Замер варианта с переменной matcher
            long startV0 = System.nanoTime();
            ListOperations.filterByAlphabetAndSortByLengthV0(data, alphabet);
            long endV0 = System.nanoTime();
            totalV0 += (endV0 - startV0);

            // Замер варианта с переменной matcher
            long startV1 = System.nanoTime();
            ListOperations.filterByAlphabetAndSortByLengthV1(data, alphabet);
            long endV1 = System.nanoTime();
            totalV1 += (endV1 - startV1);

            // Замер варианта без переменной matcher
            long startV2 = System.nanoTime();
            ListOperations.filterByAlphabetAndSortByLengthV2(data, alphabet);
            long endV2 = System.nanoTime();
            totalV2 += (endV2 - startV2);

            System.out.printf("Test %d - V0: %d ns, V1: %d ns, V2: %d ns%n", i + 1,
                    (endV0 - startV0), (endV1 - startV1), (endV2 - startV2));
        }

        System.out.printf("Average V0 (StringBuilder variable): %d ns%n", totalV0 / numTests);
        System.out.printf("Average V1 (String variable): %d ns%n", totalV1 / numTests);
        System.out.printf("Average V2 (Sting w/o variable): %d ns%n", totalV2 / numTests);
    }
}