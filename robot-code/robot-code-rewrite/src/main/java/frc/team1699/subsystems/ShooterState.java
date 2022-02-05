// package frc.team1699.subsystems;
// import frc.team1699.Constants;
// import frc.team1699.utils.LimitSwitch;
// import edu.wpi.first.wpilibj.Joystick;
// import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import edu.wpi.first.wpilibj.DoubleSolenoid;


// public class ShooterState {
//     private Joystick joystick;
//     private TalonSRX hoppMotor;
//     private TalonSRX motorcontrol;
//     private TalonSRX shooterTalonBottom;
//     private shootState currentState;
//     private LimitSwitch isLoaded;
//     private final DoubleSolenoid flipperBigSolenoid;
//     public enum shootState {
//         initialize, empty, loading, loadedNoSpin, loadedSpinning, shooting, reset, cycleSpin, cycleNoSpin
//     }
//     public ShooterState(final Joystick joystick){
//         // Objects for input + motor
//         this.joystick = joystick;
//         this.motorcontrol = new TalonSRX (Constants.kShooterTopPort);
//         this.shooterTalonBottom = new TalonSRX (Constants.kShooterBottomPort);
//         this.hoppMotor = new TalonSRX(Constants.kHopperPort);
//         this.flipperBigSolenoid = new DoubleSolenoid(0, 4, 5);
        
//     }
//     private void toggleSolenoid(final DoubleSolenoid solenoid){
//         if(solenoid.get() == DoubleSolenoid.Value.kForward){
//             solenoid.set(DoubleSolenoid.Value.kReverse);
//         }else{
//             solenoid.set(DoubleSolenoid.Value.kForward);
//         }
//     }
// public void run() throws InterruptedException {
//     switch (currentState){
//             case initialize:
//                 if (!isLoaded.isPressed()) {
//                     currentState = shootState.empty;
//                 } else {
//                     currentState = shootState.loadedNoSpin;
//                 }
//                 // If there isn't a ball in the shooter, then set the shooter state to empty. If there is, set it to loadedNoSpin. (Runs at the beginning of matches.)
//                 break;
//             case empty:
//                 if (joystick.getRawButton(1)){
//                     currentState = shootState.loading;

//                 }
//                 // If you press the button, it starts to load the shooter.
//                 break;

//             case loading:
//             //TODO: Set it so that if there is no ball in the hopper, then it won't run.
//             if (isLoaded.isPressed()) {
//                 currentState = shootState.loadedNoSpin;
//                 hoppMotor.set(TalonSRXControlMode.PercentOutput, 0);
//             } else {
//                 hoppMotor.set(TalonSRXControlMode.PercentOutput, -0.50);
//             }
//             // If the shooter is loaded, stop moving balls into it. Otherwise, start/keep moving balls into it.
//                 break;
            
            
//             case loadedNoSpin:
//                 //TODO: starts spinning, sets to loadedSpinning, unless in auto.

//                 currentState = shootState.loadedSpinning;
            
//             case loadedSpinning:
//                 //TODO: Spins wheels on the shooter, sets to shooting.
//                 shooterTalonBottom.set(TalonSRXControlMode.PercentOutput, 0.55);
//                 motorcontrol.set(TalonSRXControlMode.PercentOutput, 0.55);
//                 try{
//                     Thread.sleep(500);
//                 }catch(Exception e){
//                     System.out.println("I CANT SLEEP");
//                 }
//                 currentState = shootState.shooting;
//                 break;
            
//             case shooting:
//             // Pushes ball into shooter.
//                 toggleSolenoid(flipperBigSolenoid);
//                 currentState = shootState.reset;
//                 break;

//             case reset:
//             //TODO: Pulls back the piston that pushes the ball into the shooter, if more balls in hopper than cycleSpin, else cycleNoSpin.
//                 try{
//                     Thread.sleep(250);
//                 }catch(Exception e){
//                     System.out.println("I CANT SLEEP");
//                 }
//                 toggleSolenoid(flipperBigSolenoid);
//                     break;

//             case cycleSpin:
//             //TODO: Hopper moves another ball into the shooter, changes to loadedSpinning. (If there is another ball still in it, using the same variable from Loading.)
//                 break;

//             case cycleNoSpin:
//             //TODO: Stops shooter wheels from spinning, sets to empty.
//                 break;
//         }

//     }


// }


