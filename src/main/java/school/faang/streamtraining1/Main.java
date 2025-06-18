package school.faang.streamtraining1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(13, 5, 21, 7, 6, 10, 18);
        List<String> charList = Arrays.asList("Wolf", "Cat", "Wolverine", "Cow", "Dog", "Fox", "Deer");
        int testSum = StreamExecutor.listSum(integerList);
        System.out.println(testSum);

        int maxNum = StreamExecutor.maxNumber(integerList);
        System.out.println(maxNum);

        double averageNum = StreamExecutor.averageNumber(integerList);
        System.out.println(averageNum);

        long contFirstChar = StreamExecutor.innerCharCount(charList, 'C');
        System.out.println(contFirstChar);

        List<String> substring = StreamExecutor.filterStringContainsSubstring(charList, "Dog");
        System.out.println(substring);

        List<String> sortByLength = StreamExecutor.sortByStringLength(charList);
        System.out.println(sortByLength);

        boolean allMatchPred = StreamExecutor.isAllTrue(integerList, pred -> pred > 0);
        System.out.println(allMatchPred);

        int lowestAfterNum = StreamExecutor.lowestElementByHighest(integerList, 18);
        System.out.println(lowestAfterNum);

        List<Integer> stringToLength = StreamExecutor.stringsToLength(charList);
        System.out.println(stringToLength);
    }

}
