import airplaneException.*;

public class Main {

    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        int choice = 0;

        boolean exit = false;

        do {
            System.out.println("-------------");
            System.out.println("1 – Start motor\n" +
                    "2 – Take off\n" +
                    "3 – Stop motor\n" +
                    "4 – Increase altitude\n" +
                    "5 – Decrease altitude\n" +
                    "6 – Exit");

            choice = IO.getInt();

            try {
                switch (choice) {
                    case 1:
                        airplane.startMotor();
                        System.out.println("Airplane Started");
                        break;

                    case 2:
                        airplane.takeOff();
                        System.out.println("AirPlane took off \nCurrent Altitude : " + airplane.getAltitude());
                        break;

                    case 3:
                        airplane.stopMotor();
                        System.out.println("Motor has been stopped");
                        break;

                    case 4:
                        airplane.increaseAltitude();
                        System.out.println("Airplane: Altitude increased to " + airplane.getAltitude());
                        break;

                    case 5:
                        airplane.decreaseAltitude();
                        System.out.println("Airplane: Altitude decreased to " + airplane.getAltitude());
                        if (airplane.IsLanded())
                            System.out.println("Airplane: landed successfully");
                        break;
                    case 6:
                        exit = true;
                        return;


                    default:
                        System.out.println("Please enter valid Input");

                }

            } catch (AirplaneException exception) {
                System.err.println(exception.getMessage());
            }

        } while (!exit);
    }
}
