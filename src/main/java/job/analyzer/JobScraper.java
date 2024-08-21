package job.analyzer;


public interface JobScraper {
    Job parse(String data);
}
