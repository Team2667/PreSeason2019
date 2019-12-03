package honeycrisp.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;

public class TalonDriveTrainMotorControllers implements DriveTrainMotorControllers {
    private WPI_TalonSRX lfController, lrController, rfController, rrController;

    public void addLeftFront(WPI_TalonSRX lfController) {
        this.lfController = lfController;
    }

    public void addLeftRear(WPI_TalonSRX lrController) {
        this.lrController = lrController;
    }

    public void addRightFront(WPI_TalonSRX rfController) {
        this.rfController = rfController;
    }

    public void addRightRear(WPI_TalonSRX rrController) {
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