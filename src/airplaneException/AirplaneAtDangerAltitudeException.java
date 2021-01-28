package airplaneException;

class AirplaneAtDangerAltitudeException extends Throwable {
    public AirplaneAtDangerAltitudeException(int i2)
    {
        System.err.println("Currently Airplane at " +i2 + " altitude");
    }
}
