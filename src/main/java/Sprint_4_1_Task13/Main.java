package Sprint_4_1_Task13;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        int n = 10000000;
        List<Double> piFuture = new ArrayList<>();
        double pi;
        for (int i = 0; i < 10; i++) {
             pi = CalculateTheNumberOfPI.calculatePi(n);
             piFuture.add(pi);
        }
        double result = 0;
        for (Double p : piFuture) {
            result += p;
        }
        System.out.println(Thread.currentThread().getName() + " Pi: " + result/10);
    }
}
