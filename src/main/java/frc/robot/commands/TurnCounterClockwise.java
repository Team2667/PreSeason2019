package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.subsystems.HCDriveTrain;

public class TurnCounterClockwise extends Command{
    private HCDriveTrain driveTrain;
    private double angle;

  public TurnCounterClockwise(HCDriveTrain driveTrain, double angle) {
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
    this.angle = -angle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    driveTrain.resetGyro();
    driveTrain.turn(-.75);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.turn(-.75);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return driveTrain.getAngle() <= angle;
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
    end();
  }
}