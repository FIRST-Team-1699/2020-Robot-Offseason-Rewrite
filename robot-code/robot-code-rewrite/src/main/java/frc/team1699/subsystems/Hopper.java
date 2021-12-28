package frc.team1699.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import frc.team1699.subsystems.Subsystem;

public class Hopper{

    private final Joystick joystick;
    private final MotorController m_motor;


    public Hopper(final Joystick joystick){
        this.joystick = joystick;
        this.m_motor = new TalonSRX(port);
        //Motor Object
        
    }

    public void update(){
        //Checks for joystick button and runs hopper
        if (joystick.getRawButton(2)){
            m_motor.set(0.50);
        } else {
            m_motor.set(0);
        }

    }
}
