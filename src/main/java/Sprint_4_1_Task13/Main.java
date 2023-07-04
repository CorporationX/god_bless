package Sprint_4_1_Task13;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        int n = 10000000;
        List<Double> pif = new ArrayList<>();
        double pi;
        for (int i = 0; i < 10; i++) {
             pi = CalculateTheNumberOfPI.calculatePi(n);
             pif.add(pi);
        }
        double counttt = 0;
        for (Double p : pif) {
            counttt += p;
        }
        System.out.println("Pi: " + counttt/10);
    }
}
