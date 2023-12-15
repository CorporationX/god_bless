package faang.school.godbless.stream_api.task5eco;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем компании
        Company company1 = new Company(1, "SuperCompany", 1000);
        Company company2 = new Company(2, "FuriousCompany", 1500);
        Company company3 = new Company(3, "AwesomeCompany", 800);

        List<Company> companies = Arrays.asList(company1, company2, company3);

        // Загружаем данные из CSV файла
        List<EnvironmentalImpact> impacts = CompanyDataLoader.loadEnvironmentalImpacts("environmental_impacts.csv");
        System.out.println();

        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(companies, impacts);

        System.out.println("Analyzing Energy Consumption for SuperCompany:");
        analyzer.analyzeEnergyConsumption("environmental_impacts.csv", 1);

        System.out.println("\nAnalyzing Top Consumers:");
        analyzer.analyzeTopConsumers("environmental_impacts.csv");

        System.out.println("\nAnalyzing Energy Per Employee:");
        analyzer.analyzeEnergyPerEmployee("environmental_impacts.csv");

        // Запарился я с этим парсингом, если есть советы насчет этого был бы рад услышать
        // Конечные результаты выводил через printf, есть что-то удобнее этого метода
    }


}
