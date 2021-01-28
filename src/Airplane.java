import airplaneException.*;

public class Airplane {

    private boolean ismotorON = false;
    private int altitude = 0;
    private boolean isExploded = false;
    private boolean isTakeOff = false;
    private boolean isGrounded = true;


    public void startMotor() throws AirplaneCrashedException, AirplaneMotorAlreadyStartedException {
        crashed(altitude);
        motorIsAlreadyStarted(ismotorON && !isExploded);

        if (!ismotorON && !isExploded) {
            ismotorON = true;
            System.out.println("Motor has been started");
        }

    }

    public void motorIsAlreadyStarted(boolean b) throws AirplaneMotorAlreadyStartedException {
        if (b) {
            throw new AirplaneMotorAlreadyStartedException("");
        }
    }



    /*-----------------------------------------------------------------------------------------------------------*/

    public void stopMotor() throws AirplaneCrashedException, AirplaneMotorIsAlreadyStoppedException, AirplaneCantBeStoppedMidAirException {
        crashed(altitude);
        motorAlreadyStopped(!ismotorON);
        motorCanNotbeStoppedMidAir(!isGrounded);


        if (ismotorON && isGrounded && !isExploded) {
            ismotorON = false;
            System.out.println("Motor has been stopped");
        }
    }

    public void motorAlreadyStopped(boolean b) throws AirplaneMotorIsAlreadyStoppedException {
        if (b) {
            throw new AirplaneMotorIsAlreadyStoppedException("");
        }

    }

    public void motorCanNotbeStoppedMidAir(boolean b) throws AirplaneCantBeStoppedMidAirException {
        if (b) {
            throw new AirplaneCantBeStoppedMidAirException("");
        }
    }


    /*--------------------------------------------------------------------------------------------------------------*/


    public void takeOff() throws AirplaneCrashedException, StartMotorToTakeOffException, AirplaneAlreadyOnTheAirException {
        crashed(altitude);
        startMotorToTakeOff(!ismotorON);

        airplaneAlreadyOnTheAir(altitude > 0);

        if (ismotorON & altitude == 0 && !isExploded) {
            altitude = 1000;
            isTakeOff = true;
            isGrounded = false;
            System.out.println("AirPlane took off \nCurrent Altitude : " + altitude);
        }

    }

    public void airplaneAlreadyOnTheAir(boolean b) throws AirplaneAlreadyOnTheAirException {

        if (b) {
            throw new AirplaneAlreadyOnTheAirException("");
        }

    }

    public void startMotorToTakeOff(boolean b) throws StartMotorToTakeOffException {
        if (b) {
            throw new StartMotorToTakeOffException("");
        }

    }


    /*--------------------------------------------------------------------------------------------------------------*/


    public void increaseAltitude() throws AirplaneCrashedException, StartMotorToChangeAltitudeException, TakeOffToChangeAltitude {
        crashed(altitude);
        startMotorToIncreaseAltitude(!ismotorON);
        taleOffToChangeAltitude(!isTakeOff);
        if (ismotorON && !isExploded && isTakeOff && !isGrounded) {
            if (altitude >= 9000) {
                altitude = altitude + 1000;
                System.out.println("Danger!");
                System.out.println("Current altitude : " + altitude);

            } else {

                altitude = altitude + 1000;
                System.out.println("Current altitude : " + altitude);
            }
        }
    }

    public void startMotorToIncreaseAltitude(boolean b) throws StartMotorToChangeAltitudeException {
        if (b) {
            throw new StartMotorToChangeAltitudeException("");
        }
    }

    public void taleOffToChangeAltitude(boolean b) throws TakeOffToChangeAltitude {
        if (b) {
            throw new TakeOffToChangeAltitude("");
        }
    }


    /*--------------------------------------------------------------------------------------------------------------*/

    public void decreaseAltitude() throws AirplaneCrashedException, StartMotorToChangeAltitudeException, TakeOffToChangeAltitude {
        crashed(altitude);
        startMotorToIncreaseAltitude(!ismotorON);
        taleOffToChangeAltitude(!isTakeOff);


        if (ismotorON && !isExploded && isTakeOff && altitude == 1000) {
            altitude = altitude - 1000;
            isGrounded = true;
            isTakeOff = false;
            System.out.println("Airplane has been landed on the ground ");
            System.out.println("Current altitude : " + altitude);
        } else if (ismotorON && !isExploded && isTakeOff && altitude > 1000) {
            altitude = altitude - 1000;
            System.out.println("Current altitude : " + altitude);
        }

    }


    /*--------------------------------------------------------------------------------------------------------------*/


    public void crashed(int altitude) throws AirplaneCrashedException {
        if (altitude >= 11000) {
            altitude = altitude + 1000;
            isExploded = true;

            throw new AirplaneCrashedException("Airplane Crashed");

        }
    }

    public int getAltitude() {
        return altitude;
    }


}
