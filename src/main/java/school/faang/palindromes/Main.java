package school.faang.palindromes;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PalindromeService palindromeService = new PalindromeService();

        List<Integer> palindromicNumbers = palindromeService.getPalindromicNumbers(100, 200);


        System.out.println(palindromicNumbers);

    }
}
