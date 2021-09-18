package casestudy.utils;

public class AgeFormatException extends Throwable {
    String errorMessage;
    public AgeFormatException(String message){
        errorMessage=message;
    }
    public String getString() {
        return this.errorMessage;
    }
}
