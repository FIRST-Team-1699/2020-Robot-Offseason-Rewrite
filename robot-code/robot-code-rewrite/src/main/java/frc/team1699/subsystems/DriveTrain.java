package frc.team1699.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import frc.team1699.Constants;

public class DriveTrain implements Subsystem{


    private final Joystick joystick;
    private final TalonSRX m_leftMotor;
    private final TalonSRX m_rightMotor;
    private final TalonSRX m_leftMotorFR;
    private final TalonSRX m_rightMotorFR;
    private double throt;
    public DriveTrain(final Joystick joystick){
        this.joystick = joystick;

        // creates the motor and drive objects
        m_leftMotor = new TalonSRX(Constants.kPortDriveMainPort);
        m_rightMotor = new TalonSRX(Constants.kStarDriveMainPort);
        m_leftMotorFR = new TalonSRX(Constants.kPortDriveFollowerPort);
        m_rightMotorFR = new TalonSRX(Constants.kStarDriveFollowerPort);
        
    }
    

    protected void runArcadeDrive(double throttle, double rotate) {
        double portOutput = 0.0;
        double starOutput = 0.0;

        //TODO add deadband
        throttle = Math.copySign(throttle * throttle, throttle);
        rotate = Math.copySign(rotate * rotate, rotate);

        double maxInput = Math.copySign(Math.max(Math.abs(throttle), Math.abs(rotate)), throttle);

        if (throttle >= 0.0) {
            // First quadrant, else second quadrant
            if (rotate >= 0.0) {
                portOutput = maxInput;
                starOutput = throttle - rotate;
            } else {
                portOutput = throttle + rotate;
                starOutput = maxInput;
            }
        } else {
            // Third quadrant, else fourth quadrant
            if (rotate >= 0.0) {
                portOutput = throttle + rotate;
                starOutput = maxInput;
            } else {
                portOutput = maxInput;
                starOutput = throttle - rotate;
            }
        }
        
        // Sets the %output of the motors with z value.
        // Set it to 1 to disable
        throt = (joystick.getZ() + 1)/2;
        //throt = 1
        
        m_rightMotor.set(TalonSRXControlMode.PercentOutput, starOutput * throt);
        m_leftMotor.set(TalonSRXControlMode.PercentOutput, portOutput * throt);
        m_rightMotorFR.set(TalonSRXControlMode.PercentOutput, starOutput * throt);
        m_leftMotorFR.set(TalonSRXControlMode.PercentOutput, portOutput * throt);
        //System.out.println("Star: " + starOutput + " Port: " + portOutput);
        System.out.println("Throttle value: " + throt);
    }
    public void update(){
        //TODO Run arcade drive
        runArcadeDrive(joystick.getX(), -joystick.getY());

    }
}