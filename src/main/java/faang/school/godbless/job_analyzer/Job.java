package faang.school.godbless.job_analyzer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Job {
    @JsonProperty("position")
    private String position;
    @JsonProperty("skills")
    private List<String> skills;
    @JsonProperty("salary")
    private double salary;
    @JsonProperty("location")
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
