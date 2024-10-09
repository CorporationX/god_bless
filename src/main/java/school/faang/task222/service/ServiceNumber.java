package school.faang.task222.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ServiceNumber {
    private int firstNumber;
    private int secondNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceNumber that)) return false;

        if (firstNumber == that.firstNumber || firstNumber == that.secondNumber) {
            if (secondNumber == that.firstNumber || secondNumber == that.secondNumber) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = firstNumber;
        result = 31 * result * secondNumber;
        return result;
    }
}
