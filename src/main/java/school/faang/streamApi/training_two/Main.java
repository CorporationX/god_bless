package school.faang.streamApi.training_two;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Pairs: {}", StreamOperations.findUniquePairs(Set.of(1, 2, 3, 4, 5, 6), 6));
    }
}
