package EkologyMonitor;

public class Company {
    private int id;
    private String companyName;
    private int totalEmployees;

    public Company(int id, String companyName, int totalEmployees) {
        this.id = id;
        this.companyName = companyName;
        this.totalEmployees = totalEmployees;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }
}