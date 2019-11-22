/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package honeycrisp.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import honeycrisp.util.AnalogValueConverter;
import honeycrisp.util.PidControllerBuilder;

/**
 * Add your docs here.
 */
public abstract class HCDriveTrain extends HCSubsystem{
    private SpeedControllerGroup leftSideControllerGroup;
    private SpeedControllerGroup rightSideControllerGroup;
    private DifferentialDrive diffDrive;
    private AnalogInput distanceSensor;
    private ADXRS450_Gyro gyro;
    private double maxOutput;
    

    public HCDriveTrain(WPI_TalonSRX leftFront,  WPI_TalonSRX rightFront,  WPI_TalonSRX leftRear,  WPI_TalonSRX rightRear){
        leftSideControllerGroup = new SpeedControllerGroup(leftFront, leftRear);
        rightSideControllerGroup = new SpeedControllerGroup(rightFront, rightRear);
        diffDrive = new DifferentialDrive(leftSideControllerGroup, rightSideControllerGroup);
    }

    public void arcadeDrive(GenericHID joy) {
        diffDrive.arcadeDrive(-joy.getX(), joy.getY());
        System.out.println("Running");
    }

    public void invertLeft(){
        leftSideControllerGroup.setInverted(true);
    }

    public void invertRight(){
        rightSideControllerGroup.setInverted(true);
    }

    public HCDriveTrain(SpeedControllerGroup leftSide, SpeedControllerGroup rightSide){
        diffDrive = new DifferentialDrive(leftSide, rightSide);
    }

    public void setMaxOutput(double max){
        if (max > 0 && max < 1.0){
            diffDrive.setMaxOutput(max);
            maxOutput = max;
        }
        
    }

    public double getMaxOutput(){
        return maxOutput;
    }

    public void moveForward(double power){
       diffDrive.arcadeDrive(0, -1 * power);
    }

    public void turn(double power){
        diffDrive.arcadeDrive(-power, 0);
    }

    public void stop(){
        diffDrive.stopMotor();
    }

    public double getDistanceInInches(){
    
        double volts = distanceSensor.getVoltage();
        return  volts / 0.009766;
    }

    public void setDistanceSensor(AnalogInput distanceSensor){
        this.distanceSensor = distanceSensor;
    }

    public PIDController getDistancePIDController(double setPoint, PIDOutput output){
        PidControllerBuilder builder = new PidControllerBuilder(distanceSensor, AnalogValueConverter::inchesToVoltage);
        builder.withSetPoint(setPoint);
        builder.withPIDOutput(output);
        builder.withInputRange(0.0, 1.0);
        builder.withOutputRange(-1.0, 1.0);

        return builder.createPidController();
    }

    public void resetGyro(){
        gyro.reset();
    }

    public PIDController getGyroPIDController(double setPoint, PIDOutput output){
        PidControllerBuilder builder = new PidControllerBuilder(gyro);
        builder.withSetPoint(setPoint);
        builder.withPIDOutput(output);
        builder.withInputRange(-360.0, 360.0);
        builder.withOutputRange(-1.0, 1.0);

        return builder.createPidController();
    }

    public void setGyro(ADXRS450_Gyro gyro){
        this.gyro = gyro;
        this.gyro.calibrate();
    }

    public double getAngle(){
        return gyro.getAngle();
    }
}
