package faang.school.godbless.vacancyAnalyzer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createdAt;
}
