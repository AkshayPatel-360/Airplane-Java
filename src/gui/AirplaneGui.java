package gui;

import airplane.Airplane;
import airplaneException.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class AirplaneGui extends JFrame {




    Airplane airplane = new Airplane();
    private JFrame window ;
    JPanel westContainer;

    private JLabel status;





   /* private JButton startEngineBtn;
    private JButton stopEngineBtn;
    private JButton takeOffBtn;
    private JButton increaseAltitudeBtn;
    private JButton decreaseAltitudeBtn;*/


    public AirplaneGui()
    {
        window = new JFrame("Airplane Controller");
        window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        westContainer = new JPanel();
        window.setLayout(new BorderLayout(10,10));
        changeImage();
     // createCenterComponents();
        createWestComponents();
        window.setVisible(true);



    }



    private void createWestComponents()
    {

        westContainer.setLayout(new BoxLayout(westContainer,BoxLayout.Y_AXIS));

        JButton startMotorBtn = new JButton("Start Engine");
        JButton stopMotorBtn = new JButton("Stop Engine");
        JButton takeOffBtn = new JButton("Take Off");
        JButton increaseAltitudeBtn = new JButton("Increase Altitude");
        JButton decreaseAltitudeBtn = new JButton("Decrease Altitude");


        startMotorBtn.setBounds(50,20,50,20);

        westContainer.add(startMotorBtn);
        startMotorBtn.addActionListener(this::startEngine);


        westContainer.add(stopMotorBtn);
        stopMotorBtn.addActionListener(this:: stopEngine);

        westContainer.add(takeOffBtn);
        takeOffBtn.addActionListener(this::takeOff);

        westContainer.add(increaseAltitudeBtn);
        increaseAltitudeBtn.addActionListener(this::increaseAltitude);

        westContainer.add(decreaseAltitudeBtn);
        decreaseAltitudeBtn.addActionListener(this::decreaseAltitude);


        status = new JLabel();
        status.setBounds(500,300,20,40);
        westContainer.add(status);

        window.add(westContainer);
        westContainer.setVisible(true);

    }

    private void changeImage()
    {


        ImageIcon airplaneOnGround =  new ImageIcon(getClass().getResource("AirplaneOnGround.jpg")) ; //new ImageIcon("AirplaneOnGround.jpg");
        ImageIcon airplaneOnAir = new ImageIcon(getClass().getResource("AirplaneOnAir.jpg"));
        ImageIcon airplaneCrashed = new ImageIcon(getClass().getResource("AirplaneCrashed.jpg"));
        ImageIcon currentImageIcone;
        JLabel planeGroundLabel = null;
        JLabel planeAirLabel = null;
        JLabel planeCrashLabel ;
        Image newAirplaneStatusImage;
        if(Airplane.altitude == 0)
        {

            newAirplaneStatusImage = airplaneOnGround.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
            currentImageIcone = new ImageIcon(newAirplaneStatusImage);
            planeGroundLabel  = new JLabel(currentImageIcone);
            planeGroundLabel.setVisible(true);
            westContainer.add(planeGroundLabel);
            planeGroundLabel.setBounds(10,20,30,40);
        }
        else if(Airplane.altitude >= 1000)
        {
            System.out.println("Plane Altitude is 1000");
            newAirplaneStatusImage = airplaneOnAir.getImage().getScaledInstance(400, 900, Image.SCALE_DEFAULT);
            currentImageIcone = new ImageIcon(newAirplaneStatusImage);
            planeAirLabel = new JLabel(currentImageIcone);

            westContainer.add(planeAirLabel);
            planeAirLabel.setVisible(true);
            planeAirLabel.setBounds(60,100,30,40);
        }
        else if (Airplane.altitude>= 11000)
        {
            System.out.println("Plane Altitude is 11000");
            newAirplaneStatusImage = airplaneCrashed.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
            currentImageIcone = new ImageIcon(newAirplaneStatusImage);
            planeCrashLabel  = new JLabel(currentImageIcone);

            westContainer.add(planeCrashLabel);
            planeCrashLabel.setVisible(true);
            planeCrashLabel.setBounds(10,20,30,40);
        }



    }


    private void startEngine(ActionEvent actionEvent) {
        try {
            airplane.startMotor();
            status.setText("Airplane Started");
            //changeImage();



        } catch (AirplaneCrashedException | AirplaneMotorAlreadyStartedException exception) {

            System.out.println(exception.getMessage());
            status.setText(exception.getMessage());
        }
    }

    private void stopEngine(ActionEvent actionEvent)
    {
        try {
            airplane.stopMotor();
            status.setText("Motor has been stopped");
            //changeImage();


        } catch (AirplaneCantBeStoppedMidAirException | AirplaneMotorIsAlreadyStoppedException | AirplaneCrashedException exception) {
            System.out.println(exception.getMessage());
            status.setText(exception.getMessage());
        }
    }

    private  void takeOff(ActionEvent actionEvent)
    {

        try {
            airplane.takeOff();
            //changeImage();


            status.setText("AirPlane took off \nCurrent Altitude : " + airplane.getAltitude());
        } catch (AirplaneAlreadyOnTheAirException | AirplaneAtDangerAltitudeException | StartMotorToChangeAltitudeException | AirplaneCrashedException | AirplaneMotorIsAlreadyStoppedException | TakeOffToChangeAltitude | AirplaneCantBeStoppedMidAirException | StartMotorToTakeOffException exception) {
            System.out.println(exception.getMessage());
            status.setText(exception.getMessage());
        }
    }

    private void increaseAltitude(ActionEvent actionEvent)
    {

        try {
            airplane.increaseAltitude();
            //changeImage();
            status.setText("Airplane: Altitude increased to " + airplane.getAltitude());
        } catch (StartMotorToChangeAltitudeException | TakeOffToChangeAltitude | AirplaneCrashedException | AirplaneAtDangerAltitudeException exception) {
            System.out.println(exception.getMessage());
            status.setText(exception.getMessage());
        }

    }

    private void decreaseAltitude(ActionEvent actionEvent)
    {
        try {

            //changeImage();
            airplane.decreaseAltitude();

            status.setText("Airplane: Altitude decreased to " + airplane.getAltitude());
            if (airplane.IsLanded())
                status.setText("Airplane Landed Successfully");


        } catch (StartMotorToChangeAltitudeException | TakeOffToChangeAltitude | AirplaneCrashedException | AirplaneAtDangerAltitudeException exception) {
            System.out.println(exception.getMessage());
            status.setText(exception.getMessage());
        }
    }





}
