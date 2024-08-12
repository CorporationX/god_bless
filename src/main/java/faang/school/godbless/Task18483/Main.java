package faang.school.godbless.Task18483;

public class Main {

    public static void main(String[] args) {

        try{
           User user = new User("Adel", 17, "Bishkek", "London");
           System.out.println(user);
       }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
