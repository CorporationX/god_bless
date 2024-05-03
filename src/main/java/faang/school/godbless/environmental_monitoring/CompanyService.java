package faang.school.godbless.environmental_monitoring;

import java.util.HashMap;
import java.util.Map;

public class CompanyService {
    private final Map<Integer, Company> COMPANIES;

    public CompanyService() {
        this.COMPANIES = new HashMap<>();
        COMPANIES.put(1, new Company(1, "company1", 300));
        COMPANIES.put(2, new Company(2, "company2", 300));
        COMPANIES.put(3, new Company(3, "company3", 300));
        COMPANIES.put(4, new Company(4, "company4", 400));
        COMPANIES.put(5, new Company(5, "company5", 400));
        COMPANIES.put(6, new Company(6, "company6", 400));
        COMPANIES.put(7, new Company(7, "company7", 500));
        COMPANIES.put(8, new Company(8, "company8", 500));
        COMPANIES.put(9, new Company(9, "company9", 600));
    }

    public void addCompany(Company company) {
        COMPANIES.put(company.getId(), company);
    }

    public Company getCompanyById(int id) {
        return COMPANIES.getOrDefault(id, null);
    }
}