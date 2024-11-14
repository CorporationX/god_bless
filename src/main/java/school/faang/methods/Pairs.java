package school.faang.methods;

import lombok.Data;

@Data
public class Pairs {
    private int firstNum;
    private int secondNum;

    public Pairs(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }
}
