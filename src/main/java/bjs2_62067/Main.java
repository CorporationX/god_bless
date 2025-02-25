package bjs2_62067;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int NUM_OF_POINTS = 10_000_000; // Количество случайных точек для генерации

    public static void main(String[] args) {
        double pi = PiValueCalculator.calculatePi(NUM_OF_POINTS); // Запуск вычисления Пи
        log.info("Приближенное значение Пи: {}", pi);
    }
}
