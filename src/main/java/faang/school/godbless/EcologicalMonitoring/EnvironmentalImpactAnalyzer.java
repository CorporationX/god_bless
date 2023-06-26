package faang.school.godbless.EcologicalMonitoring;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    public void analyze(String file, int companyId) {
        Company company = Companies.getById(companyId);
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.dataLoad(file);
        System.out.println("Company Name: " + company.getCompanyName());
        System.out.println("Today's date: " + LocalDate.now());
        System.out.println("Month  EnergyConsumption");
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        environmentalImpacts.stream()
                .filter(impact -> impact.getType() == EType.ENERGY_CONSUMPTION && impact.getCompanyId() == companyId)
                .collect(Collectors.groupingBy(impact -> impact.getDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate(), Collectors.toList()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> Double.parseDouble(entry.getKey().getYear() + "." + entry.getKey().getMonthValue())))/*.forEach((k,v) -> System.out.println(k + "/" + v));*/
                .entrySet()
                .stream()
                .flatMap(entry -> entry.getValue().stream().flatMap(list -> list.getValue().stream().map(impact -> Arrays.asList(entry.getKey(), impact.getVolume()))))
                .collect(Collectors.toMap(list -> list.get(0), list -> Double.parseDouble(list.get(1).toString()), Double::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> {
                    total.updateAndGet(v -> v + entry.getValue());
                    System.out.println(entry.getKey() + "    " + entry.getValue());
                });
        System.out.println("Total    " + total);
    }

    public void mostImpact(String file, Date currentDate) {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.dataLoad(file);

        System.out.println(        environmentalImpacts.stream()
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId))
                .entrySet()
                .stream()
                .map(entry -> Arrays.asList(entry.getKey(), entry.getValue().stream().mapToDouble(EnvironmentalImpact::getVolume).sum()))
                .collect(Collectors.toList()));

    }

    public void averageEnergy(String file, Date currentDate) {

    }

}
