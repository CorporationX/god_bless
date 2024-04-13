package faang.school.godbless.bjs2_5257;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class Main {

    private static final String SOURCE_CSV = "/files/envinonmental_impacts.csv";

    public static void main(String[] args) {

        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer();

        System.out.println("\nStatistic energy consumption by company");
        analyzer.printEnergyConsumptionByMonth(SOURCE_CSV, 51);

        System.out.println("\nStatistic energy consumption by company");
        analyzer.printTop3EnergyConsumption(SOURCE_CSV, LocalDate.now());

        System.out.println("\nStatistic consumption per employee for a year");
        analyzer.printConsumptionPerEmployeeForYear(SOURCE_CSV, LocalDate.now());
    }
}
