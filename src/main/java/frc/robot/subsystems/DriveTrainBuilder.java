/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.AnalogInput;
import honeycrisp.subsystems.HCDriveTrainBuilder;

/**
 * Add your docs here.
 */
public class DriveTrainBuilder extends HCDriveTrainBuilder<DriveTrain>{
    protected DriveTrain newDriveTrain(CANSparkMax leftFront,  CANSparkMax rightFront,  CANSparkMax leftRear,  CANSparkMax rightRear){
        return new DriveTrain(leftFront, rightFront,leftRear,rightRear);
    }
    
}
