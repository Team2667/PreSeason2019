package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.ArmExtender;

public class ExtendArm extends Command {
    private ArmExtender armExtender;
    private long endMillis;
  public ExtendArm(ArmExtender armExtender) {
    this.armExtender = armExtender;
  }


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      endMillis = System.currentTimeMillis()  + 1000;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      this.armExtender.move(.7);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  //  return System.currentTimeMillis() >= endMillis; 
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      armExtender.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    armExtender.stop();
  }
}