package school.faang.palindromes;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PalindromeService palindromeService = new PalindromeService();

        List<Integer> palindromicNumbers = palindromeService.getPalindromicNumbers(10, 1000);
        Set<String> palindromicStrings = palindromeService.getPalindromicStrings("abac");

        System.out.println(palindromicNumbers);
        System.out.println(palindromicStrings);

    }
}
