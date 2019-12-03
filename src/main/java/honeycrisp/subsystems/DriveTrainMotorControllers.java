package honeycrisp.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

public interface DriveTrainMotorControllers {
    public SpeedController getLeftFront();
    public SpeedController getRightFront();
    public SpeedController getRightRear();
    public SpeedController getLeftRear();

    // Add Methods to make the drive train move based on encoders

    public void moveAtVelocity(int rpm) ;
}