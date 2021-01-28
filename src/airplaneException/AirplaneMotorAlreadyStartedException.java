package airplaneException;

public class AirplaneMotorAlreadyStartedException extends Exception
{
    public AirplaneMotorAlreadyStartedException(String message)
    {
        super(message);
    }
}
