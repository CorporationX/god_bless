package school.faang.sprint2.task_BJS2_60200.palindrome;

public class PalindromeGenerator {
    private final Figure val = new Figure();
    private final Figure evenVal = new Figure();
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
        int evenRoot = val.getVal();
        StringBuilder sequence = val.getSequence();

        val.increment();
        return createPalindrome(evenRoot, sequence);
    }

    private int getEvenPalindrome() {
        String stringEvenRoot = String.valueOf(evenVal.getVal()).repeat(2);
        int evenRoot = Integer.parseInt(stringEvenRoot);
        StringBuilder sequence = evenVal.getSequence();

        evenVal.increment();
        return createPalindrome(evenRoot, sequence);
    }


    private int createPalindrome(int val, StringBuilder sequence) {
        String palindrome = sequence.toString() + val + sequence.reverse();
        return Integer.parseInt(palindrome);
    }

}
