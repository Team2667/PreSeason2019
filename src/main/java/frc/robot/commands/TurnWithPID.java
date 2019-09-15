package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

public class TurnWithPID extends Command implements PIDOutput{
    private HCDriveTrain driveTrain;
    private PIDController pidController;
    private double angle;


    public TurnWithPID(HCDriveTrain driveTrain, double angle) {
        this.driveTrain = driveTrain;
        this.requires(driveTrain);
        this.angle = angle;
      }
    
      // Called just before this Command runs the first time
      @Override
      protected void initialize() {
        driveTrain.resetGyro();
        pidController = driveTrain.getGyroPIDController(angle, this);

        // ToDo: Once the unit test cases pass, we will run
        // the robot and adjust these values until you get the robot to turn
        // smoothly
        pidController.setP(.04);
        pidController.setI(0);
        pidController.setD(0);
        pidController.setPercentTolerance(1.0);
        pidController.enable();
      }
    
      // Called repeatedly when this Command is scheduled to run
      @Override
      protected void execute() {
        // For commands that use pidController and implement the PIDOutput interface, the pidWrite
        // method gets the code that advances the robot. 
      }
    
      // Make this return true when this Command no longer needs to run execute()
      @Override
      protected boolean isFinished() {
          // ToDo: call some method on PIDController to determine if the robot has turned far enough.
          return false;
      }
    
      // Called once after isFinished returns true
      @Override
      protected void end() {
            // ToDo: disable and close pidController.
            // Note: disabling can only be done once. Use an if statement to verify
            // the pidController is enabled before disabling and closing it.
      }
    
      // Called when another command which requires one or more of the same
      // subsystems is scheduled to run
      @Override
      protected void interrupted() {
         
      }

      public void pidWrite(double p){
          // p gives you both the speed and direction in which to turn the robot.
        System.out.println(p);
      }
}