// package frc.team1699.subsystems;
// import edu.wpi.first.wpilibj.Joystick;
// import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import frc.team1699.Constants;
// public class Hopper{

//     // Classes for input + motor
//     private final Joystick joystick;
//     private final TalonSRX m_motor;


//     public Hopper(final Joystick joystick){
//         // Objects for input + motor
//         this.joystick = joystick;
//         this.m_motor = new TalonSRX(Constants.kHopperPort);
        
//     }

//     public void update(){
//         //Checks for joystick button and runs hopper
//         if (joystick.getRawButton(2)){
//             m_motor.set(TalonSRXControlMode.PercentOutput, -0.50);
//         } else {
//             m_motor.set(TalonSRXControlMode.PercentOutput,0);
//         }

//     }
// }
