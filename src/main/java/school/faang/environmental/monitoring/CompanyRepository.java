package school.faang.environmental.monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyRepository {
    private final Map<Integer, Company> companies = new HashMap<>();

    public void addCompanies(List<Company> companyList) {
        companyList.forEach(company -> companies.put(company.getId(), company));
    }

    public Company getCompany(int id) {
        return companies.get(id);
    }

    public Map<String, Integer> employeesCountByCompany(List<String> companyNames) {
        return companies.values().stream()
                .filter(company -> companyNames.contains(company.getCompanyName()))
                .collect(Collectors.toMap(
                        Company::getCompanyName,
                        Company::getTotalEmployees));
    }
}
