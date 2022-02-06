package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.team1699.Constants;
import frc.team1699.subsystems.DriveTrain;
//import frc.team1699.subsystems.Shooter;
//import frc.team1699.subsystems.Intake;
//import frc.team1699.subsystems.Hopper;

public class Robot extends TimedRobot {

  //Setup Joysticks
  private Joystick driveJoystick; 
  private Joystick operatorJoystick;

  //Setup Subsystems
  private DriveTrain kDriveTrain;
 // private Shooter kShooter;
 // private Intake kIntake;
 // private Hopper kHopper;

  //Setup Compressor
  private Compressor compressor;

  @Override
  public void robotInit() {
      //Init Joysticks
      driveJoystick = new Joystick(Constants.kDriveJoystickPort);
      operatorJoystick = new Joystick(Constants.kOperatorJoystickPort);

      //Init Subsystems
      kDriveTrain = new DriveTrain(driveJoystick);
      //kShooter = new Shooter(operatorJoystick);
    //  kIntake = new Intake(operatorJoystick);
    //  kHopper = new Hopper(operatorJoystick);
      
      //Init compressor
     // compressor = new Compressor(0);
     // compressor.start();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
      kDriveTrain.update();
     // kShooter.update();
   //   kIntake.update();
  //    kHopper.update();
  }

  @Override
  public void disabledInit() {
      
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
