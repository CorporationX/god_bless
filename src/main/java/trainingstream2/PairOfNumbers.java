package trainingstream2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PairOfNumbers {
    private int firstNumber;
    private int secondNumber;

    public static void sortPairOfNumbers(PairOfNumbers pairOfNumbers) {
        if (pairOfNumbers.getFirstNumber() > pairOfNumbers.getSecondNumber()) {
            int buffer = pairOfNumbers.getSecondNumber();
            pairOfNumbers.setSecondNumber(pairOfNumbers.getFirstNumber());
            pairOfNumbers.setFirstNumber(buffer);
        }
    }
}
