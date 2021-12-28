package frc.team1699.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import frc.team1699.subsystems.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Shooter implements Subsystem {
private final TalonSRX motorcontrol;
    private final Joystick joystick;
private final TalonSRX shooterTalonBottom;
private final DoubleSolenoid flipperBigSolenoid;
private final DoubleSolenoid shooterAngleSolenoid;
    public Shooter(final Joystick joystick) {
        this.joystick = joystick;
motorcontrol = new TalonSRX (16);
shooterTalonBottom = new TalonSRX (12);
flipperBigSolenoid = new DoubleSolenoid(0, 4, 5);
shooterAngleSolenoid = new DoubleSolenoid(0, 6, 7);
        //TODO Create motor object
       
        //TODO Create solenoid object
    }


    public void update(){

        //TODO Check for joystick button and run shooter if pressed
        if(joystick.getRawButton(4)){
            shooterTalonBottom.set(0.55);
            motorcontrol.set(0.55);
        } else {(joystick.getRawButton(4)){
            shooterTalonBottom.set(0);
            motorcontrol.set(0);
            
        }
        //TODO Check for joystick button and run flipper if pressed
        if(joystick.getRawButtonPressed(9)){
            toggleSolenoid(flipperBigSolenoid);
        }
        //TODO Check for joystick button and adjust shooter angle if pressed
        if (joystick.getRawButtonPressed(10)){
            toggleSolenoid(shooterAngleSolenoid);}
    }
    private void toggleSolenoid(final DoubleSolenoid solenoid){
        if(solenoid.get() == DoubleSolenoid.Value.kForward){
            solenoid.set(DoubleSolenoid.Value.kReverse);
        }else{
            solenoid.set(DoubleSolenoid.Value.kForward);
        }
    }
}