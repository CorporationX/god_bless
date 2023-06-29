package faang.school.godbless.job_analyzer;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobStreamProcessorTest {

    @Test
    public void testProcessJobs() {
        Stream<String> jobDataStream = Stream.of(
                "{\"position\":\"Software Engineer\",\"requirements\":[\"Java\",\"Spring\",\"REST\"],\"salary\":80000,\"location\":\"San Francisco\",\"dateAdded\":\"2023-06-25\"}",
                "{\"position\":\"Software Engineer\",\"requirements\":[\"Java\",\"Spring\",\"REST\"],\"salary\":80000,\"location\":\"San Francisco\",\"dateAdded\":\"2023-06-25\"}",
                "{\"position\":\"Software Engineer\",\"requirements\":[\"Java\",\"Spring\",\"REST\"],\"salary\":80000,\"location\":\"San Francisco\",\"dateAdded\":\"2023-06-25\"}"
        );

        JobStreamProcessor streamProcessor = new JobStreamProcessor();

        JList<Job> jobList = streamProcessor.processJobs(jobDataStream);

        DefaultListModel<Job> jobListModel = (DefaultListModel<Job>) jobList.getModel();
        List<Job> jobs = Collections.list(jobListModel.elements());

        assertEquals(3, jobs.size());
        assertEquals("Software Engineer", jobs.get(0).getPosition());
        assertEquals("Software Engineer", jobs.get(1).getPosition());
        assertEquals("Software Engineer", jobs.get(2).getPosition());
    }
}
