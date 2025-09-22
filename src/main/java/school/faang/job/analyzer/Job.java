package school.faang.job.analyzer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String position;
    private Integer salary;
    private List<String> requirements = new ArrayList<>();
    private String location;
    // почему не работает?
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePosted;
}
