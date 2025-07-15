package school.faang.bjs2_80783;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pair {
    private final int firstNumber;
    private final int secondNumber;



    @Override
    public String toString() {
        return String.format("(%s, %s)", firstNumber, secondNumber);
    }
}