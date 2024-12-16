package school.faang.sprint_2.task_bjs247247;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                ListOperations.findUniquePairs(TestDataGenerator.getForFindUniquePairs(),
                        7));
        System.out.println(
                ListOperations.getSortedCapitals(TestDataGenerator.getForSortedCapitals()));
        System.out.println(
                ListOperations.filterAndSortByLength(TestDataGenerator.getForFilterAndSortByLength(),
                        'a'));
        System.out.println(
                ListOperations.toBinaryString(TestDataGenerator.getForToBinaryString()));
        System.out.println(
                ListOperations.filterAlphabetSortByLength(TestDataGenerator.getForFilterAlphabetSortByLength(),
                        "abcdefghijklmnopqrstuvwxyz"));
    }
}
