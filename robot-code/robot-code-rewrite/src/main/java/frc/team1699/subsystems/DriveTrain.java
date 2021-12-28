package team1699.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import team1699.subsystems.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PWMSpeedController;

public class DriveTrain implements Subsystem{

    
    private final Joystick joystick;
    private final TalonFX m_leftMotor;
    private final TalonFX m_rightMotor;
    private final TalonFX m_leftMotorFR;
    private final TalonFX m_rightMotorFR;

    public DriveTrain(final Joystick joystick){
        this.joystick = joystick;

        // creates the motor and drive objects
        m_leftMotor = new TalonFX(Constants.kPortDriveMainPort);
        m_rightMotor = new TalonFX(Constants.kStarDriveMainPort);
        m_leftMotorFR = new TalonFX(Constants.kPortDriveFollowerPort);
        m_rightMotorFR = new TalonFX(Constants.kStarDriveFollowerPort);
        
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

        m_rightMotor.set(portOutput);
        m_leftMotor.set(starOutput);
        m_rightMotorFR.set(portOutput);
        m_leftMotorFR.set(starOutput);
    }
    public void update(){
        //TODO Run arcade drive
        runArcadeDrive(joystick.getX(), -joystick.getY());
    }
}