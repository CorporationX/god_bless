package school.faang.practice_streamapi_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> stringList = Arrays.asList("Alice", "Bob", "David", "Anton", "Alex", "Boris", "Tom", "Alexey");
        logger.info("The list of number = {}", (intList));
        logger.info("The summa of number = {}", StreamApiPractice.summList(intList));
        logger.info("The max of number = {}", StreamApiPractice.maxInList(intList));
        logger.info("The average of number = {}", StreamApiPractice.avgInList(intList));
        char symbol = 'A';
        logger.info("The count strings begin at char '{}' = {}",
                symbol, StreamApiPractice.findCount(stringList, symbol));
        String substring = "Alex";
        logger.info("The list of strings that include a substring '{}': {}", substring,
                StreamApiPractice.includeSubstring(stringList, substring));
        logger.info("The sorted list order by length: {}", StreamApiPractice.lengthSortedList(stringList));
        logger.info("Do all the items in the list {} satisfy a certain condition? - {}",
                intList, StreamApiPractice.isAllMatch(intList, i -> i > 5));
        logger.info("Min of numbers {} after filter: {}",
                intList, StreamApiPractice.minOfFilterNumbers(intList, 6));
        logger.info("The list of Strings {} to list of Length: {}",
                stringList, StreamApiPractice.mapStringList(stringList));
    }
}
