
public class InvalidException extends RuntimeException {

    //having the invalid exception as it's own class
    private String message;

    public InvalidException() {
        this("Invalid");
    }

    public InvalidException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}