package school.faang.basic.reverse;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};

        log.info(Arrays.toString(Example.reverse(input)));
        log.info(Arrays.toString(input));
    }
}