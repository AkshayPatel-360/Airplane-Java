public class Airplane {

    private boolean ismotorON = false;
    private int altitude = 0;
    private boolean isExploded = false;
    private boolean isTakeOff = false;
    private boolean isGrounded = true;



    public void startMotor()
    {
        crashed(altitude);

        if (ismotorON && !isExploded)
        {
            System.out.println("Motor has already been started ");
        }

        else if (!ismotorON && !isExploded)
        {
            ismotorON = true;
            System.out.println("Motor has been started");
        }

    }

    public void stopMotor()
    {
        crashed(altitude);
        if (!isGrounded && !isExploded)
        {
            System.out.println("You can not stop motor when Airplane is in the air");
            System.out.println("Current altitude :" + altitude );
        }
        else if (ismotorON && isGrounded  && !isExploded)
        {
            ismotorON = false;
            System.out.println("Motor has been stopped");
        }
    }



    public void  takeOff()
    {
        crashed(altitude);
        if (altitude> 0 && !isExploded)
        {
            System.out.println("Airplane already in the air. ");
        }

        else if (ismotorON & altitude==0 && !isExploded)
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

        if(!ismotorON && !isExploded && !isTakeOff && isGrounded)
        {
            System.out.println("Please start motor to increase altitude");
        }

        else if(ismotorON && !isExploded && !isTakeOff && isGrounded)
        {
            System.out.println("Please take off to increase altitude");
        }

        else if(ismotorON && !isExploded && isTakeOff && !isGrounded )
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

        if (isGrounded && !isExploded )
        {
            System.out.println("You are already on the ground you can not go down further");
        }

        if (ismotorON && !isExploded && isTakeOff && altitude == 1000)
        {
            altitude = altitude - 1000;
            isGrounded = true;
            isTakeOff = false;
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
            altitude = altitude + 1000;
            System.out.println(" Airplane crashed ");
            //System.out.println("Current altitude : " + altitude);

            isExploded = true;

        }
    }





}
