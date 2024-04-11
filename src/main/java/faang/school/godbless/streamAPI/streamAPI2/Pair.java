package faang.school.godbless.streamAPI.streamAPI2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Pair {
    private int firstNum;
    private int secondNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        System.out.println((firstNum == pair.firstNum && secondNum == pair.secondNum) || (secondNum == pair.firstNum && firstNum == pair.secondNum));
        return (firstNum == pair.firstNum && secondNum == pair.secondNum) || (secondNum == pair.firstNum && firstNum == pair.secondNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNum, secondNum);
    }
}
