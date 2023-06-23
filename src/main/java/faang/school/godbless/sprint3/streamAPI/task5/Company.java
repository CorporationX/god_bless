package faang.school.godbless.sprint3.streamAPI.task5;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {

    private int id;

    private String companyName;

    private int totalEmployees;
}
