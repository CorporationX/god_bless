package school.faang.streamtraining1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(13, 5, 21, 7, 6, 10, 18);
        List<String> charList = Arrays.asList("Wolf", "Cat", "Wolverine", "Cow", "Dog", "Fox", "Deer");
        int testSum = StreamProducer.listSum(integerList);
        System.out.println(testSum);

        int maxNum = StreamProducer.maxNumber(integerList);
        System.out.println(maxNum);

        double averageNum = StreamProducer.averageNumber(integerList);
        System.out.println(averageNum);

        long contFirstChar = StreamProducer.innerCharCount(charList, 'C');
        System.out.println(contFirstChar);

        List<String> substring = StreamProducer.filterStringBySubstring(charList, "Dog");
        System.out.println(substring);

        List<String> sortByLength = StreamProducer.sortByStringLength(charList);
        System.out.println(sortByLength);

        boolean allMatchPred = StreamProducer.isAllTrue(integerList, pred -> pred > 0);
        System.out.println(allMatchPred);

        int lowestAfterNum = StreamProducer.lowestElementByHighest(integerList, 18);
        System.out.println(lowestAfterNum);

        List<Integer> stringToLength = StreamProducer.stringsToLength(charList);
        System.out.println(stringToLength);
    }

}
