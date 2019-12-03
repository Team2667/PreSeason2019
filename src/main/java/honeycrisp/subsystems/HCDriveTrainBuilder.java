package honeycrisp.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public abstract class HCDriveTrainBuilder<T extends HCDriveTrain> {
    private WPI_TalonSRX lfTalon;
    private WPI_TalonSRX rfTalon;
    private WPI_TalonSRX lrTalon;
    private WPI_TalonSRX rrTalon;
    private AnalogInput distanceSensor;
    private ADXRS450_Gyro gyro;
    private boolean isLeftInverted = false;
    private boolean isRightInverted = false;
    private double maxOutput = 1.0;

    public HCDriveTrainBuilder(){
    }

    public HCDriveTrainBuilder<T> addLfSpeedControler(int canId){
        lfTalon = new WPI_TalonSRX(canId);
        return this;
    }

    public HCDriveTrainBuilder<T> addRfSpeedControler(int canId){
        rfTalon = new WPI_TalonSRX(canId);
        return this;
    }

    public HCDriveTrainBuilder<T> addLrSpeedControler(int canId){
        lrTalon = new WPI_TalonSRX(canId);
        return this;
    }
    
    public HCDriveTrainBuilder<T> addRrSpeedControler(int canId){
        rrTalon = new WPI_TalonSRX(canId);
        return this;
    }

    public HCDriveTrainBuilder<T> addDistanceSensor(int id){
        distanceSensor = new AnalogInput(id);
        return this;
    }

    public HCDriveTrainBuilder<T> addGyro(){
        gyro = new ADXRS450_Gyro();
        return this;
    }

    public HCDriveTrainBuilder<T> invertLeft(){
        isLeftInverted = true;
        return this;
    }

    public HCDriveTrainBuilder<T> invertRight(){
        isRightInverted = true;
        return this;
    }

    public HCDriveTrainBuilder<T> setMaxOutput(double max){
        this.maxOutput = max;
        return this;
    }

    public T build(){
        TalonDriveTrainMotorControllers controllers = new TalonDriveTrainMotorControllers();
        controllers.addLeftFront(lfTalon);
        controllers.addRightFront(rfTalon);
        controllers.addLeftRear(lrTalon);
        controllers.addRightRear(rrTalon);
        T dt = newDriveTrain(controllers);
        
        dt.setDistanceSensor(distanceSensor);
        dt.setGyro(gyro);
        if (isRightInverted){
            dt.invertRight();
        }
        if (isLeftInverted){
            dt.invertLeft();
        }
        dt.setMaxOutput(maxOutput);
        return dt;
    }

    abstract protected T newDriveTrain(DriveTrainMotorControllers controllers);
}