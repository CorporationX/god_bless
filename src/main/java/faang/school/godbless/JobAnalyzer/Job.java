package faang.school.godbless.JobAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    String name;
    List<String> requirements;
    int margin;
    String location;
    String createdAt;
}

