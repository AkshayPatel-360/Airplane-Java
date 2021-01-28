import airplaneException.*;

public class Main {

    public static void main(String[] args) throws AirplaneCrashedException {

        Airplane airplane = new Airplane();
        int choice = 0;

        while (true) {
            System.out.println("-------------");
            System.out.println("1 – Start motor\n" +
                    "2 – Take off\n" +
                    "3 – Stop motor\n" +
                    "4 – Increase altitude\n" +
                    "5 – Decrease altitude\n" +
                    "6 – Exit");

            choice = IO.getInt();

            switch (choice) {
                case 1 -> {
                    try {
                        airplane.startMotor();
                    } catch (AirplaneCrashedException airplaneCrashedException) {
                        System.err.println("Airplane Crashed");
                    } catch (AirplaneMotorAlreadyStartedException airplaneMotorAlreadyStartedException) {
                        System.err.println("The motor has already been started ");
                    }


                }


                case 2 -> {
                    try {
                        airplane.takeOff();
                    } catch (AirplaneCrashedException airplaneCrashedException) {
                        System.err.println("Airplane Crashed");
                    } catch (StartMotorToTakeOffException startMotorToTakeOffException) {
                        System.err.println("Please start motor to take off ");
                    } catch (AirplaneAlreadyOnTheAirException e) {
                        System.err.println("Airplane already in the air, You can't take off while you are in the air ");
                    }


                }

                case 3 -> {
                    try {
                        airplane.stopMotor();
                    } catch (AirplaneCrashedException airplaneCrashedException) {
                        System.err.println("Airplane Crashed");
                    } catch (AirplaneMotorIsAlreadyStoppedException airplaneMotorIsAlreadyStoppedException) {
                        System.err.println("The motor has already been stopped");
                    } catch (AirplaneCantBeStoppedMidAirException e) {
                        System.err.println("You can not stop motor when Airplane is in the air");
                        System.err.println("Current altitude :" + airplane.getAltitude());
                    }

                }


                case 4 -> {
                    try {
                        airplane.increaseAltitude();
                    } catch (AirplaneCrashedException airplaneCrashedException) {
                        System.err.println("Airplane Crashed");
                    } catch (StartMotorToChangeAltitudeException e) {
                        System.err.println("Please Start motor and take Off to increase altitude");
                    } catch (TakeOffToChangeAltitude e) {
                        System.err.println("Please take off to increase altitude");
                    }
                }


                case 5 -> {
                    try {
                        airplane.decreaseAltitude();
                    } catch (AirplaneCrashedException airplaneCrashedException) {
                        System.err.println("Airplane Crashed");
                    } catch (StartMotorToChangeAltitudeException e) {
                        System.err.println("Please Start motor and take Off to decrease altitude");
                    } catch (TakeOffToChangeAltitude e) {
                        System.err.println("Please take off to decrease altitude");
                        System.err.println("Current altitude : " + airplane.getAltitude());
                    }
                }


                case 6 -> {
                    System.out.println("You have successfully exited ");
                    return;
                }

                default -> System.out.println("Please enter valid Input");


            }
        }


    }


}
