package faang.school.godbless.BJS2_10757;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JobScrapper {
    public Job convertJsonStringToJob(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Job.class);
    }

    public String convertJsonStringFromFile(String filename) throws FileNotFoundException {
        Object o = new JsonParser().parse(new FileReader(filename));
        return o.toString();
    }
}
