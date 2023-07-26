package faang.school.godbless.wizard_tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {
   public CompletableFuture<School> startTask(School school, Task task){
      CompletableFuture<School> futureSchool = new CompletableFuture<>();
      List<Student> studentList = new ArrayList<>();

      for (Student student : school.getStudentList()){
         try {
            System.out.println(student.getName() + " started doing " + task.getName());
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println(student.getName() + " finished " + task.getName());
         student.setPoints(student.getPoints() + task.getReward());
         studentList.add(student);
      }

      school.setStudentList(studentList);
      futureSchool.complete(school);

      return futureSchool;
   }
}
