package faang.school.godbless.stream_api.task5eco;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
    private int id;
    private String companyName;
    private int totalEmployees;
}
