package teacher;

public class TeacherRegistrationException extends RuntimeException {

    public TeacherRegistrationException(){

    }
    public TeacherRegistrationException(String message) {
      super(message);
    }

    public TeacherRegistrationException(Throwable t) {
        super(t);
    }

    public TeacherRegistrationException(String message, Throwable t) {
        super(message, t);
    }

}
