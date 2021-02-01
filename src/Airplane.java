import airplaneException.*;

public class Airplane {

    private final int RATE_OF_CHANGE = 1000;
    private final int WARNING_ALTITUDE = 10000;
    public final int EXPLOSION_ALTITUDE = 12000;

    private int altitude = 0;

    private AirplaneEnum status = AirplaneEnum.MOTOR_OFF;

    public boolean IsLanded() {
        return status != AirplaneEnum.EXPLODED && status != AirplaneEnum.FLYING;
    }

    public void startMotor() throws AirplaneCrashedException, AirplaneMotorAlreadyStartedException {

        switch (status) {

            case EXPLODED:
                throw new AirplaneCrashedException("Airplane Exploded");
            case MOTOR_ON:
            case FLYING:
                throw new AirplaneMotorAlreadyStartedException("Motor already started");
            case MOTOR_OFF:
                status = AirplaneEnum.MOTOR_ON;
                break;
        }
    }

    /*-----------------------------------------------------------------------------------------------------------*/

    public void stopMotor() throws AirplaneCrashedException, AirplaneMotorIsAlreadyStoppedException, AirplaneCantBeStoppedMidAirException {

        switch (status) {

            case EXPLODED:
                throw new AirplaneCrashedException("Crashed");

            case FLYING:
                throw new AirplaneCantBeStoppedMidAirException("Can't top motor mid air");

            case MOTOR_OFF:
                throw new AirplaneMotorIsAlreadyStoppedException("Motor is already off");
            case MOTOR_ON:
                status = AirplaneEnum.MOTOR_OFF;
                break;
        }
    }

    /*--------------------------------------------------------------------------------------------------------------*/

    public void takeOff() throws AirplaneCrashedException, StartMotorToTakeOffException, AirplaneAlreadyOnTheAirException, AirplaneCantBeStoppedMidAirException, AirplaneMotorIsAlreadyStoppedException, TakeOffToChangeAltitude, StartMotorToChangeAltitudeException, AirplaneAtDangerAltitudeException {
        switch (status) {


            case EXPLODED:
                throw new AirplaneCrashedException("Crashed");
            case MOTOR_OFF:
                throw new StartMotorToTakeOffException("Please start motor first");
            case FLYING:
                throw new AirplaneAlreadyOnTheAirException("Airplane is in the air");
            case MOTOR_ON:
                status = AirplaneEnum.FLYING;
                increaseAltitude();
                break;

        }
    }

    /*--------------------------------------------------------------------------------------------------------------*/

    public void increaseAltitude() throws AirplaneCrashedException, StartMotorToChangeAltitudeException, TakeOffToChangeAltitude, AirplaneAtDangerAltitudeException {

        switch (status) {

            case EXPLODED:
                throw new AirplaneCrashedException("Airplane Crashed");
            case MOTOR_OFF:
                throw new StartMotorToChangeAltitudeException("Can not increase altitude without starting Motor");
            case MOTOR_ON:
                throw new TakeOffToChangeAltitude("Can not increase altitude without taking off");
            case FLYING:
                altitude = altitude + RATE_OF_CHANGE;
                checkAltitude();
                break;
        }
    }

    private void checkAltitude() throws AirplaneCrashedException, AirplaneAtDangerAltitudeException {
        switch (altitude) {
            case EXPLOSION_ALTITUDE:
                status = AirplaneEnum.EXPLODED;
                throw new AirplaneCrashedException("Aiplane: BOOM!");
            case WARNING_ALTITUDE:
            case WARNING_ALTITUDE + 1000: /*--------------------------------------------------------------*/
                throw new AirplaneAtDangerAltitudeException("WARNING: The plane cannot support pressure at 12000 altitude.\nCurrent altitude: " + altitude);
            case 0:
                status = AirplaneEnum.MOTOR_ON;
            default:
                break;
        }
    }

    /*--------------------------------------------------------------------------------------------------------------*/

    public void decreaseAltitude() throws AirplaneCrashedException, StartMotorToChangeAltitudeException, TakeOffToChangeAltitude, AirplaneAtDangerAltitudeException {
        switch (status) {

            case EXPLODED:
                throw new AirplaneCrashedException("Airplane crashed");
            case MOTOR_OFF:
                throw new StartMotorToChangeAltitudeException("Start motor First");
            case MOTOR_ON:
                throw new TakeOffToChangeAltitude("Can not decrease altitude while airplane is on the ground");
            case FLYING:
                altitude -= RATE_OF_CHANGE;
                checkAltitude();
                break;
        }
    }

    /*--------------------------------------------------------------------------------------------------------------*/

    public int getAltitude() {
        return altitude;
    }

}
