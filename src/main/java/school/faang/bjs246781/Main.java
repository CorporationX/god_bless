package school.faang.bjs246781;

import java.util.List;

public class Main {
    private static final int START_NUM = 100;
    private static final int END_NUM = 500;
    private static final String LETTERS = "abac";

    public static void main(String[] args) {

        Operations operations = new Operations();

        List<String> palindromNumbers = operations.findPalindromNumbers(START_NUM, END_NUM);
        System.out.println(palindromNumbers);

        List<String> palindromSubstrings = operations.findPalindromSubstrings(LETTERS);
        System.out.println(palindromSubstrings);

        List<Integer> perfectNumbers = operations.findPerfectNumbers(START_NUM, END_NUM);
        System.out.println(perfectNumbers);
    }
}