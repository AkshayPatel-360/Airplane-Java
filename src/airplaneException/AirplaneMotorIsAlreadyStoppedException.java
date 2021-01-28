package airplaneException;

public class AirplaneMotorIsAlreadyStoppedException extends Exception{
    public AirplaneMotorIsAlreadyStoppedException(String message)
    {
        super(message);
    }
}
