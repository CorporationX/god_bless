package school.faang.sprint_2.task_46716.repository;

import lombok.NonNull;
import school.faang.sprint_2.task_46716.entity.Company;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class CompanyRepository {
    private static final Set<Company> companies = new HashSet<>();

    public static void addCompany(@NonNull Company company) {
        companies.add(company);
    }

    public static Optional<Company> getCompanyById(int id) {
        return companies.stream()
                .filter(company -> company.getId() == id)
                .findFirst();
    }

    public static void removeCompany(@NonNull Company company) {
        companies.remove(company);
    }

    public static Set<Company> getCompanies() {
        return Set.copyOf(companies);
    }

    public static void addCompanies(@NonNull Set<Company> companiesToAdd) {
        companies.addAll(companiesToAdd);
    }

    public static void generateCompany(int id) {
        String name = "Company" + id;
        CompanyRepository.addCompany(new Company(id, name, new Random().nextInt(1000)));
    }
}
