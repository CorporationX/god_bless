package faang.school.godbless.eco_monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Company {
    private int id;
    private String name;
    private int employeeQuantity;
    public static List<Company> companies;

    static {
        companies = List.of(
                new Company(1, "ABC Company", 100),
                new Company(2, "XYZ Company", 20),
                new Company(3, "DEF Company", 50)
        );
    }
}
