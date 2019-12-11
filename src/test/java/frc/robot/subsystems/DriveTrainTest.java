/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.junit.Test;
import com.revrobotics.CANSparkMax;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import com.revrobotics.CANSparkMax;

/**
 * Add your docs here.
 */
public class DriveTrainTest {
    @Test
    public void canCreateADriveTraingObject(){
        CANSparkMax lfTalon = mock(CANSparkMax.class);
        CANSparkMax rfTalon = mock(CANSparkMax.class);
        CANSparkMax lrTalon = mock(CANSparkMax.class);
        CANSparkMax rrTalon = mock(CANSparkMax.class);

        DriveTrain dt = new DriveTrain(lfTalon,rfTalon, lrTalon, rrTalon);
        assertNotNull(dt);
    }
}
