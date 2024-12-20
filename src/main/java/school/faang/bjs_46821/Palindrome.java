package school.faang.bjs_46821;

public class Palindrome {

    public static boolean isPalindrome(int number) {
        String numberString = String.valueOf(number);
        return isPalindrome(numberString);
    }

    public static boolean isPalindrome(String s) {
        String reverseString = new StringBuilder(s).reverse().toString();
        return s.equals(reverseString);
    }
}
