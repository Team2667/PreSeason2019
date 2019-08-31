package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

/*
 * Move the robot forward for a specified number of milliseconds.
 * Hints:
 *  1. second equals 1000 milliseconds
 *  2. Call System.currentTimeMillis() to get the number of milliseconds that have passed since 
 *     January 1, 1970 12:00am GMT
 * 
*/
public class MoveForMilliSeconds extends Command {
  private HCDriveTrain driveTrain;
  private long endMillis;
  private int runTimeInMillis;
  private double power;


  public MoveForMilliSeconds(HCDriveTrain driveTrain, int millis, double power) {
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
    this.runTimeInMillis = millis;
    this.power = power;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    endMillis = System.currentTimeMillis()  + runTimeInMillis;
    driveTrain.moveForward(power);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.moveForward(power);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() >= endMillis;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}