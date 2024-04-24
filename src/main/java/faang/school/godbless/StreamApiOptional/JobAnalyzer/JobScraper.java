package faang.school.godbless.StreamApiOptional.JobAnalyzer;

import com.google.gson.Gson;

public class JobScraper {
    public static Job convertJSONtoNewJobObject(String json){

        Gson gson = new Gson();

        return gson.fromJson(json, Job.class);
    }
}

//{
//        "name": "Software Engineer",
//        "requirements": ["Bachelor's degree in Computer Science", "Proficiency in Java and Python", "Experience with web development frameworks"],
//        "margin": 2000,
//        "location": "San Francisco",
//        "date": "2024-04-13T08:30:00"
//        }


//используйте peek() для вывода в консоль.
//map() для преобразования данных.
//filter() и Optional для того, чтобы отбросить элементы, которые могут быть null.
//
//используйте collect() для сбора данных из стрима в список,
//используйте groupingBy для группировки по какому-то значению.
