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
                .collect(Collectors.groupingBy(EnvironmentalImpact::getDate))
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

    public void mostImpact(String file, LocalDate currentDate) {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.dataLoad(file);
        collectVolumes(environmentalImpacts,currentDate)
                .entrySet()
                .stream()
                .map(e -> Arrays.asList(
                        Companies.getById(e.getKey()).getCompanyName(),
                        e.getValue().values().stream().mapToDouble(vol -> vol).sum(),
                        e.getValue().values().stream().mapToDouble(vol -> vol).average().orElseThrow(),
                        e.getValue().values().stream().min(Comparator.comparingDouble(vol -> vol)).orElseThrow()
                ))
                .toList()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(list -> Double.parseDouble(list.get(1).toString()))))
                .limit(3)
                .toList()
                .forEach(System.out::println);
    }

    public void averageEnergy(String file, LocalDate currentDate) {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.dataLoad(file);
        collectVolumes(environmentalImpacts,currentDate)
                .entrySet()
                .stream()
                .map(e -> Arrays.asList(
                        Companies.getById(e.getKey()).getCompanyName(),
                        e.getValue().values().stream().mapToDouble(vol -> vol).sum(),
                        Companies.getById(e.getKey()).getTotalEmployees(),
                        e.getValue().values().stream().mapToDouble(vol -> vol).sum() / Companies.getById(e.getKey()).getTotalEmployees()
                ))
                .toList()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(list -> Double.parseDouble(list.get(1).toString()))))
                .limit(3)
                .toList()
                .forEach(System.out::println);
    }

    private static Map<Integer, Map<String, Double>> collectVolumes(List<EnvironmentalImpact> environmentalImpacts,LocalDate currentDate) {
        return environmentalImpacts.stream()
                .filter(environmentalImpact -> environmentalImpact.getDate().isBefore(currentDate) && environmentalImpact.getDate().isAfter(currentDate.minusYears(1)))
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, impact -> impact.getValue()
                                .stream()
                                .collect(Collectors.groupingBy(envImp -> envImp.getDate().getYear() + "." + envImp.getDate().getMonthValue()))
                                .entrySet()
                                .stream()
                                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().mapToDouble(EnvironmentalImpact::getVolume).average().orElseThrow()))
                        )
                );
    }
}


