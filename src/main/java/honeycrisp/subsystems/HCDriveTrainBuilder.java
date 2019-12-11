package honeycrisp.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public abstract class HCDriveTrainBuilder<T extends HCDriveTrain> {
    private CANSparkMax lfTalon;
    private CANSparkMax rfTalon;
    private CANSparkMax lrTalon;
    private CANSparkMax rrTalon;
    private AnalogInput distanceSensor;
    private ADXRS450_Gyro gyro;
    private boolean isLeftInverted = false;
    private boolean isRightInverted = false;
    private double maxOutput = 1.0;

    public HCDriveTrainBuilder(){
    }

    public HCDriveTrainBuilder<T> addLfSpeedControler(int canId){
        lfTalon = new CANSparkMax(canId,MotorType.kBrushless);
        return this;
    }

    public HCDriveTrainBuilder<T> addRfSpeedControler(int canId){
        rfTalon = new CANSparkMax(canId,MotorType.kBrushless);
        return this;
    }

    public HCDriveTrainBuilder<T> addLrSpeedControler(int canId){
        lrTalon = new CANSparkMax(canId,MotorType.kBrushless);
        return this;
    }
    
    public HCDriveTrainBuilder<T> addRrSpeedControler(int canId){
        rrTalon = new CANSparkMax(canId,MotorType.kBrushless);
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
        T dt = newDriveTrain(lfTalon,rfTalon,lrTalon,rrTalon);
        
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

    abstract protected T newDriveTrain(CANSparkMax leftFront,  CANSparkMax rightFront,  CANSparkMax leftRear,  CANSparkMax rightRear);
}