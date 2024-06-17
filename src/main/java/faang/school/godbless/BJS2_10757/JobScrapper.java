package faang.school.godbless.BJS2_10757;

import com.google.gson.Gson;

public class JobScrapper {
    public Job convertJsonStringToJob(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Job.class);
    }
}
