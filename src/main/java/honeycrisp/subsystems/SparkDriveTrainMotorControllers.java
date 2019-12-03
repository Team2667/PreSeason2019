package honeycrisp.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedController;

public class SparkDriveTrainMotorControllers implements DriveTrainMotorControllers {
    CANSparkMax lfController, lrController, rfController, rrController;

    public void addLeftFront(CANSparkMax lfController) {
        this.lfController = lfController;
    }

    public void addLeftRear(CANSparkMax lrController) {
        this.lrController = lrController;
    }

    public void addRightFront(CANSparkMax rfController) {
        this.rfController = rfController;
    }

    public void addRightRear(CANSparkMax rrController) {
        this.rrController = rrController;
    }

    public SpeedController getLeftFront() {
        return lfController;
    }

    public SpeedController getRightFront() {
        return rfController;
    }

    public SpeedController getRightRear() {
        return rrController;
    }

    public SpeedController getLeftRear() {
        return lrController;
    }

    public void moveAtVelocity(int rpm) {
        // TODO
    }
}