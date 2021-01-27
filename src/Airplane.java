public class Airplane {

    private boolean ismotorON = false;
    public int altitude = 0;
    private boolean isExploded = false;
    private boolean isTakeOff = false;
    private boolean isGrounded = true;



    public void startMotor()
    {
        crashed(altitude);
        if (!ismotorON)
        {
            ismotorON = true;
            System.out.println("Motor has been started");
        }

    }

    public void stopMotor()
    {
        crashed(altitude);
        if (!isGrounded)
        {
            System.out.println("You can not stop motor when Airplane is in the air");
            System.out.println("Current altitude :" + altitude );
        }
        else if (ismotorON && isGrounded)
        {
            ismotorON = false;
            System.out.println("Motor has been stopped");
        }
    }



    public void  takeOff()
    {
        crashed(altitude);
        if (altitude> 0)
        {
            System.out.println("Airplane already in the air. ");
        }

        else if (ismotorON & altitude==0 )
        {
            altitude = 1000;
            isTakeOff = true;
            isGrounded = false;
            System.out.println("AirPlane took off \nCurrent Altitude : " + altitude);
        }

    }

    public void increaseAltitude()
    {
        crashed(altitude);
        if(ismotorON && !isExploded && isTakeOff )
        {
            if (altitude >= 9000 )
            {
                altitude = altitude+1000;
                System.out.println("Danger!");
                System.out.println("Current altitude : " + altitude);

            }
            else {

                altitude = altitude + 1000;
                System.out.println("Current altitude : " + altitude);
            }
        }

    }

    public void decreaseAltitude()
    {
        crashed(altitude);

        if (ismotorON && !isExploded && isTakeOff && altitude == 1000)
        {
            altitude = altitude - 1000;
            isGrounded = true;
            System.out.println("Airplane has been landed on the ground ");
            System.out.println("Current altitude : " + altitude);
        }


        else if(ismotorON && !isExploded && isTakeOff && altitude > 1000)
        {
            altitude = altitude - 1000;
            System.out.println("Current altitude : " + altitude);
        }

    }




    public void crashed(int altitude)
    {
        if(altitude >=11000 )
        {
            System.out.println("Airplane is crashed ");
            isExploded = true;

        }
    }





}
