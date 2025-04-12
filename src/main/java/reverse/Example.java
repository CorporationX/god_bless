package reverse;

public class Example {

    public void reverse(int[] digits) {
        for (int i = 0; i < digits.length / 2; i++) {
            int temp = digits[i];
            digits[i] = digits[digits.length - 1 - i];
            digits[digits.length - 1 - i] = temp;
        }
    }
}
