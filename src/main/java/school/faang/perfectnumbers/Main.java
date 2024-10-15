package school.faang.perfectnumbers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PerfectNumbersService numbersService = new PerfectNumbersService();
        List<Integer> perfectNumbers = numbersService.getPerfectNumbers(1, 1000);
        System.out.println(perfectNumbers);
    }
}
