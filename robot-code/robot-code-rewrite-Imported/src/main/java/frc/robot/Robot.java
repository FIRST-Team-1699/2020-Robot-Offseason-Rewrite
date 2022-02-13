package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
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
  
  private boolean canSeeTarget;


  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry tv = table.getEntry("tv");

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
    //kDriveTrain.update();
     // kShooter.update();
   //   kIntake.update();
  //    kHopper.update();
  
    // A bunch of magic numbers used to aim the robot at the target
    final double kSteer = 0.03;
    final double kDrive = 0.26;



    //limelight values
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double isTarget = tv.getDouble(0.0);
    
    //how far the x can be away from the target to be considered aimed
    double kAimMargin = 4;

    if (isTarget < 1){
      canSeeTarget = false;
    } else {
      canSeeTarget = true;
    }

    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("Target found", isTarget);
    

    if (driveJoystick.getRawButton(1) && Math.abs(x) >= kAimMargin){
      // its pid but minus the id. its just p. pp. haha.
      kDriveTrain.runArcadeDrive(x*kSteer, 0, false);
    } else {
      kDriveTrain.runArcadeDrive(driveJoystick.getX(), -driveJoystick.getY(), true);
    }
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
