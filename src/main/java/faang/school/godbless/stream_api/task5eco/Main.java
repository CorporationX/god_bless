package faang.school.godbless.stream_api.task5eco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем компании
        Company company1 = new Company(1, "SuperCompany", 1000);
        Company company2 = new Company(2, "FuriousCompany", 1500);
        Company company3 = new Company(3, "AwesomeCompany", 800);

        List<Company> companies = Arrays.asList(company1, company2, company3);

        // Загружаем данные из CSV файла
        List<EnvironmentalImpact> impacts = CompanyDataLoader.loadEnvironmentalImpacts("environmental_impacts.csv");

        // Анализируем данные
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(companies, impacts);

        // Примеры вызовов методов анализатора
        System.out.println("Analyzing Energy Consumption for SuperCompany:");
        analyzer.analyzeEnergyConsumption("environmental_impacts.csv", 1);

        System.out.println("\nAnalyzing Top Consumers:");
        analyzer.analyzeTopConsumers("environmental_impacts.csv", new Date());

        System.out.println("\nAnalyzing Energy Per Employee:");
        analyzer.analyzeEnergyPerEmployee("environmental_impacts.csv", new Date());

        analyzer.printCompanyImpacts(1); // Печать всех EnvironmentalImpact для SuperCompany
        analyzer.analyzeEnergyConsumption("environmental_impacts.csv", 1);

    }


}
