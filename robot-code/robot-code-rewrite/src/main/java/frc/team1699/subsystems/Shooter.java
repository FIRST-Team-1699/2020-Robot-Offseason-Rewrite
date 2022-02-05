// package frc.team1699.subsystems;
// import edu.wpi.first.wpilibj.Joystick;
// import frc.team1699.Constants;

// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

// public class Shooter implements Subsystem {
//   private final TalonSRX motorcontrol;
//     private final Joystick joystick;
//   private final TalonSRX shooterTalonBottom;
//   private final DoubleSolenoid flipperBigSolenoid;
//   private final DoubleSolenoid shooterAngleSolenoid;

//   private final TalonSRX hopper;
  
//   public Shooter(final Joystick joystick) {
//         this.joystick = joystick;
//         motorcontrol = new TalonSRX (16);
//         shooterTalonBottom = new TalonSRX (12);
//         flipperBigSolenoid = new DoubleSolenoid(0, 4, 5);
//         shooterAngleSolenoid = new DoubleSolenoid(0, 6, 7);
//         // Creates object for hopper motor, used to load balls
//         hopper = new TalonSRX(Constants.kHopperPort);

        
    
//     }

//     // public void ShootThenLoad(){

//     //         // Spin up the flywheels
//     //         shooterTalonBottom.set(TalonSRXControlMode.PercentOutput, 0.55);
//     //         motorcontrol.set(TalonSRXControlMode.PercentOutput, 0.55);
//     //         // Delay
//     //         TimeUnit.SECONDS.sleep(1);
//     //         // Make sure flipper is down
//     //         if(flipperBigSolenoid.get() == DoubleSolenoid.Value.kForward){
//     //             flipperBigSolenoid.set(DoubleSolenoid.Value.kReverse);
//     //         }else{
//     //             flipperBigSolenoid.set(DoubleSolenoid.Value.kForward);
//     //         }
//     //         // Run the hopper motor for some time
//     //         hopper.set(TalonSRXControlMode.PercentOutput, -0.50);
//     //         TimeUnit.SECONDS.sleep(1);
//     //         hopper.set(TalonSRXControlMode.PercentOutput, 0);
//     //         // Make the flipper go up then down
//     //         flipperBigSolenoid.set(DoubleSolenoid.Value.kReverse);
//     //         TimeUnit.SECONDS.sleep(0.4);
//     //         flipperBigSolenoid.set(DoubleSolenoid.Value.kForward);            
//     // }
    

//     public void update(){

//         //TODO Check for joystick button and run shooter if pressed
//         if(joystick.getRawButton(4)){
//             shooterTalonBottom.set(TalonSRXControlMode.PercentOutput, 0.55);
//             motorcontrol.set(TalonSRXControlMode.PercentOutput, 0.55);
//         // } else {
//         //     if (joystick.getRawButton(1)){
//         //         ShootThenLoad();
//         //     }
//             // shooterTalonBottom.set(TalonSRXControlMode.PercentOutput, 0);
//             // motorcontrol.set(TalonSRXControlMode.PercentOutput, 0);
            
//         }
//         //TODO Check for joystick button and run flipper if pressed
//         if(joystick.getRawButtonPressed(9)){
//             toggleSolenoid(flipperBigSolenoid);
//         }
//         //TODO Check for joystick button and adjust shooter angle if pressed
//         if (joystick.getRawButtonPressed(10)){
//             toggleSolenoid(shooterAngleSolenoid);}
//     }
//     private void toggleSolenoid(final DoubleSolenoid solenoid){
//         if(solenoid.get() == DoubleSolenoid.Value.kForward){
//             solenoid.set(DoubleSolenoid.Value.kReverse);
//         }else{
//             solenoid.set(DoubleSolenoid.Value.kForward);
//         }
//     }
// }