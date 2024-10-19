package school.faang.BJS2_35972_HelpColleague;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "surname")
    private String surname;

    @CsvBindByName(column = "age")
    private int age;

    @CsvBindByName(column = "workplace")
    private String workplace;
}
