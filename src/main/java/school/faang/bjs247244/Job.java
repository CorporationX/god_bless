package school.faang.bjs247244;

import lombok.Data;

import java.util.List;


@Data
public class Job {
    private String position;
    private List<String> requirements;
    private String salary;
    private String location;
    private String datePosted;
}


