package frc.team1699.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import frc.team1699.subsystems.Subsystem;
import frc.team1699.Constants;


public class Intake implements Subsystem{

    private final Joystick joystick;

    private final TalonSRX talonSRX;
    private final DoubleSolenoid solenoid;
    public Intake(final Joystick joystick){
        this.joystick = joystick;

        //TODO Create motor object
        talonSRX = new TalonSRX(Constants.kIntakePort);
        
        //TODO Create solenoid object
        solenoid= new DoubleSolenoid(Constants.kIntakeSolenoidForwardPort,Constants.kIntakeSolenoidReversePort);
    }

    public void update(){
        //TODO Check for joystick button and run intake motor
        if(joystick.getRawButton(1)){
            talonSRX.set(TalonSRXControlMode.PercentOutput,-0.55);
        }else{
            talonSRX.set(TalonSRXControlMode.PercentOutput,0.0);
        }
        
        //TODO Check for joystick button and deploy or retract intake
        if(joystick.getRawButton(3)){
            solenoid.set(1);
        }else{
            solenoid.set(0);
        }
    }
}
