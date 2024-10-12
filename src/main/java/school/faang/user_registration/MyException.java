package school.faang.user_registration;

public class MyException extends IllegalArgumentException {
    protected final static int NAME_BLANK = 1;
    protected final static int INVALID_AGE = 2;
    protected final static int INVALID_JOB = 3;
    protected final static int INVALID_ADDRESS = 4;

    public MyException(int myExceptionCode) {
        if (myExceptionCode == 1) {
            System.out.println("The person's name is blank!");
        } else if (myExceptionCode == 2) {
            System.out.println("The person's age doesn't meet the minimum requirement!");
        } else if (myExceptionCode == 3) {
            System.out.println("The person's job is invalid!");
        } else {
            System.out.println("The person's address is invalid!");
        }
    }
}
