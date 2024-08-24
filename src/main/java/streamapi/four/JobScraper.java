package streamapi.four;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JobScraper {

    protected ObjectMapper objectMap;

    public JobScraper() {
        this.objectMap = new ObjectMapper();
    }

    public abstract Job parse(String source);
}
