package school.faang.bjs2_79222;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] numbers = {1, 2, 3, 4, 5};
        log.info("Исходный массив: {}", Arrays.toString(numbers));
        int[] reversedNumbers = example.reverse(numbers);
        log.info("Инвертированный массив: {}", Arrays.toString(reversedNumbers));
    }
}
