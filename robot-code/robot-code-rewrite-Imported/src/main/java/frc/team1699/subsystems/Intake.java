// package frc.team1699.subsystems;

// import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.PneumaticsModuleType;
// import frc.team1699.Constants;


// public class Intake implements Subsystem{
//     private boolean locked = false;
//     private final Joystick joystick;

//     private final TalonSRX talonSRX;
//     private final DoubleSolenoid solenoid;
//     public Intake(final Joystick joystick){
//         this.joystick = joystick;

//         //TODO Create motor object
//   //      talonSRX = new TalonSRX(Constants.kIntakePort);
        
//         //TODO Create solenoid object
//         solenoid= new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.kIntakeSolenoidForwardPort,Constants.kIntakeSolenoidReversePort);
//     }

//     public void update(){
//         //TODO Check for joystick button and run intake motor
//         if(joystick.getRawButton(5)){
//             talonSRX.set(TalonSRXControlMode.PercentOutput, -0.55);
//         }else{
//             talonSRX.set(TalonSRXControlMode.PercentOutput, 0.0);
//         }
        
//         //TODO Check for joystick button and deploy or retract intake
//         if(joystick.getRawButton(3) && !locked){
//             toggleSolenoid(solenoid);
//             locked = true;
//         }
        
//         if(!joystick.getRawButton((3))) {
//             locked = false;
//         }
//     }

//     private void toggleSolenoid(final DoubleSolenoid solenoid){
//         if(solenoid.get() == DoubleSolenoid.Value.kForward){
//             solenoid.set(DoubleSolenoid.Value.kReverse);
//         }else{
//             solenoid.set(DoubleSolenoid.Value.kForward);
//         }
//     }
// }
