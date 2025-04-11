package school.faang.expandArray;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1, 0};
        log.info("Original array - [{}]", array);
        log.info("Reversed array - [{}]", Example.reverse(array));
    }
}