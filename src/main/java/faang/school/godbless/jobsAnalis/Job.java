package faang.school.godbless.jobsAnalis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Job {
    private final String title;
    private List<String> skills;
    private Integer salary;
    private String location;
    private Date date;

    public Job(String title, List<String> requirements, Integer salary, String location) {
        this.title = title;
        this.skills = requirements;
        this.salary = salary;
        this.location = location;
        this.date = new Date();
    }

    @JsonCreator
    public Job(@JsonProperty("title") String title, @JsonProperty("skills") List<String> skills,
               @JsonProperty("salary") Integer salary, @JsonProperty("location") String location,
               @JsonProperty("date") Date date) {
        this.title = title;
        this.skills = skills;
        this.salary = salary;
        this.location = location;
        this.date = date;
    }
}
