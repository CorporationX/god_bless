package faang.school.godbless.jobAnalyzer;

import com.google.gson.Gson;
public class JobScraper {
    public Job convertJsonToJob(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Job.class);
    }
}
