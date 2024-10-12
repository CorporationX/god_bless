package job_analyzer;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {
    private static final String FILE_PATH = "vacancies.json";

    @Test
    void printTop5Skills() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(FILE_PATH);
             Stream<String> jsonStream = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()) {
            JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
            List<Job> jobs = jobStreamProcessor.processJobs(jsonStream);

            DataAnalyzer dataAnalyzer = new DataAnalyzer();
            dataAnalyzer.printTop5Skills(jobs);

            assertEquals(
                    """
                            JavaScript: 40
                            SQL: 35
                            Agile: 35
                            Spring: 33
                            Azure: 31
                            """,
                    outContent.toString()
            );
        } catch (
                IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        System.setOut(originalOut);
    }

    @Test
    void printTop5Positions() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(FILE_PATH);
             Stream<String> jsonStream = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()) {
            JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
            List<Job> jobs = jobStreamProcessor.processJobs(jsonStream);

            DataAnalyzer dataAnalyzer = new DataAnalyzer();
            dataAnalyzer.printTop5Positions(jobs);

            assertEquals(
                    """
                            Data Scientist: 23
                            QA Engineer: 19
                            Software Engineer: 19
                            Product Manager: 16
                            Backend Developer: 16
                            """,
                    outContent.toString()
            );
        } catch (
                IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        System.setOut(originalOut);
    }

    @Test
    void printSalaryDistribution() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(FILE_PATH);
             Stream<String> jsonStream = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()) {
            JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
            List<Job> jobs = jobStreamProcessor.processJobs(jsonStream);

            DataAnalyzer dataAnalyzer = new DataAnalyzer();
            dataAnalyzer.printSalaryDistribution(jobs);

            assertEquals(
                    """
                            100k+: 101
                            50k-100k: 49
                            """,
                    outContent.toString()
            );
        } catch (
                IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        System.setOut(originalOut);
    }

    @Test
    void printTop5Locations() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(FILE_PATH);
             Stream<String> jsonStream = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()) {
            JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
            List<Job> jobs = jobStreamProcessor.processJobs(jsonStream);

            DataAnalyzer dataAnalyzer = new DataAnalyzer();
            dataAnalyzer.printTop5Locations(jobs);

            assertEquals(
                    """
                            London: 21
                            San Francisco: 18
                            Beijing: 17
                            Paris: 17
                            Tokyo: 16
                            """,
                    outContent.toString()
            );
        } catch (
                IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        System.setOut(originalOut);
    }
}