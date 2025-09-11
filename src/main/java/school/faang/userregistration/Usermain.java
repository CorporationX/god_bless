package school.faang.userregistration;



public class Usermain {
    public static void main(String[] args) {

        User user = new User("name", 17, "Google", "London");
        User user1 = new User("name1", 18, "Googl", "London");
        User user2 = new User("name2", 18, "Google", "Londo");
        User user3 = new User("name3", 18, "Google", "London");
        User user4 = new User("name4", 18, "Google", "London");

        try {
            ValidatorRegistrator.validate(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            ValidatorRegistrator.validate(user1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            ValidatorRegistrator.validate(user2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            ValidatorRegistrator.validate(user3);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            ValidatorRegistrator.validate(user4);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }



    }
}
