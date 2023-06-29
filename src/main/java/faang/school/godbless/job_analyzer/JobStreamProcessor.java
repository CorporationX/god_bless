package faang.school.godbless.job_analyzer;

import javax.swing.*;
import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    public JList<Job> processJobs(Stream<String> jobDataStream) {
        DefaultListModel<Job> jobListModel = new DefaultListModel<>();

        List<Job> jobs = jobDataStream
                .map(new JobScraper()::parseJobFromJsonString)
                .toList();

        for (Job job : jobs) {
            jobListModel.addElement(job);
            System.out.println("New job notification: " + job);
        }

        return new JList<>(jobListModel);
    }
}
