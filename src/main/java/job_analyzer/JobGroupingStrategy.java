package job_analyzer;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface JobGroupingStrategy {
    Map<String, List<Job>> groupJobs(List<Job> jobs);
}
