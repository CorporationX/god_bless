package school.faang.sprint2.task_BJS2_60200.palindrome;

public class PalindromeGenerator {
    private final Figure val = new Figure();
    private final Figure evenVal = new Figure(1);
    private int palindrome = 1;
    private int evenPalindrome = 11;

    public int getNextPalindrome() {
        if (palindrome > evenPalindrome) {
            evenPalindrome = getEvenPalindrome();
        } else {
            palindrome = getPalindrome();
        }
        return Math.min(evenPalindrome, palindrome);
    }

    private int getPalindrome() {
        val.increment();
        StringBuilder sequence = val.getSequence();
        if (!sequence.isEmpty()) {
            sequence.deleteCharAt(0);
        }
        return createPalindrome(String.valueOf(val.getVal()),  sequence);
    }

    private int getEvenPalindrome() {
        evenVal.increment();
        return createPalindrome("", evenVal.getSequence());
    }


    private int createPalindrome(String val, StringBuilder sequence) {
        String palindrome = sequence.reverse() + val + sequence.reverse();
        return Integer.parseInt(palindrome);
    }

}
