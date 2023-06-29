package faang.school.godbless.sprint3.streamAPI.task5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private int id;

    private String companyName;

    private int totalEmployees;

    public static List<Company> companies;

    static {
        companies = List.of(
                new Company(1, "FuriousCompany", 11815),
                new Company(2, "SuperCompany", 14580),
                new Company(3, "AwesomeCompany", 9846)
        );
    }
}
