package faang.school.godbless.jobanalyzer;

import com.google.gson.*;

public class JobScraper {
    public static Job convertJSONStringToJob(String jsonString) {

        Gson gson = new Gson();
        return gson.fromJson(jsonString, Job.class);
    }
}
