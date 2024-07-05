package faang.school.godbless.LetsCalculateTheNumberOfPI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PiCalculation piCalculation = new PiCalculation();
        log.info(String.valueOf(piCalculation.calculate(100000000)));
    }
}
