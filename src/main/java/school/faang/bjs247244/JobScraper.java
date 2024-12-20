package school.faang.bjs247244;

import com.google.gson.Gson;

public class JobScraper {
    private final Gson gson = new Gson();

    public Job parseJob(String jsonString) {
        return gson.fromJson(jsonString, Job.class);
    }
}
