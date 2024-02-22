package Test;

import java.util.Map;

enum EnvironmentalImpactType {
    ENERGY_CONSUMPTION, GAS_EMISSION
}

class Company {
    private int id;
    private String companyName;
    private int employees;

    public Company(int id, String companyName, int employees) {
        this.id = id;
        this.companyName = companyName;
        this.employees = employees;
    }

    public static String getCompanyNameById(int companyId, Map<Integer, Company> companies) {
        Company company = companies.get(companyId);
        return (company != null) ? company.getCompanyName() : "Unknown Company";
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getId() {
        return id;
    }

    public int getEmployees() {
        return employees;
    }
}