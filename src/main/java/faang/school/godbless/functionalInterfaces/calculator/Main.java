package faang.school.godbless.functionalInterfaces.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> nums = new ArrayList<>();
        nums.add(16.0);
        nums.add(4.0);
        nums.add(2.0);
        nums.add(2.0);

        System.out.println("\nSumming list of one number:");
        try {
            System.out.println(CalculationProcessor.sum(List.of(1.0)));
        } catch (Exception e) {
            System.out.println("Exception was caught. Exception message: " + e.getMessage());
        }

        System.out.println("\nSumming nums:");
        System.out.println(CalculationProcessor.sum(nums));

        System.out.println("\nProduct of null-valued list:");
        try {
            System.out.println(CalculationProcessor.product(null));
        } catch (Exception e) {
            System.out.println("Exception was caught. Exception message: " + e.getMessage());
        }

        System.out.println("\nProduct of nums");
        System.out.println(CalculationProcessor.product(nums));

        nums.add(0, 0.0);
        System.out.println("\nDividing nums:");
        System.out.println(CalculationProcessor.division(nums));

        nums.add(0.0);
        System.out.println("\nDividing nums (nums now contains zero):");
        try {
            System.out.println(CalculationProcessor.division(nums));
        } catch (Exception e) {
            System.out.println("Exception was caught. Exception message: " + e.getMessage());
        }
    }
}
