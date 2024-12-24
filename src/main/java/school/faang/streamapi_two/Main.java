package school.faang.streamapi_two;

import lombok.extern.slf4j.Slf4j;

import static school.faang.streamapi_two.TestData.emptyList;
import static school.faang.streamapi_two.TestData.numbers;
import static school.faang.streamapi_two.TestData.countries;
import static school.faang.streamapi_two.TestData.fruit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        SolutionMethods solutionMethods = new SolutionMethods();

        try {
            log.info("{}", solutionMethods.findUniquePairs(numbers, 7));
            log.info("{}", solutionMethods.findUniquePairs(numbers, 9));
            log.info("{}", solutionMethods.sortCapitalByAlphabet(countries));
            log.info("{}", solutionMethods.findStringStartingWithCharAndSort(fruit, 'a'));
            log.info("{}", solutionMethods.convertIntegerToBinaryString(numbers));
            log.info("{}", solutionMethods.filterByAlphabetAndSort(fruit, "abcdefghijklmnopqrstuvwxyz"));
            log.info("{}", solutionMethods.convertIntegerToBinaryString(emptyList));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
    }
}
