package faang.school.godbless.task.jobAnalyzer;

import com.google.gson.Gson;

public class JobScraper {
    public static Job convertJsonToJob(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Job.class);
    }
}
