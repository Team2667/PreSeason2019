package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Add your docs here.
 */
public class TurnCounterClockwiseTest {
    private DriveTrain dt;
    private TurnCounterClockwise turn;
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;
    
    @Test
    public void initializeStartsTheRobotTurning(){
        turn.initialize();
        verify(leftSide,times(1)).set(anyDouble());
        verify(rightSide,times(1)).set(anyDouble());
    }

    @Test
    public void executeAdjustsTheRobot(){
        turn.initialize();
        turn.execute();
        verify(leftSide,times(2)).set(anyDouble());
        verify(rightSide,times(2)).set(anyDouble());
    }

    @Test
    public void isFinishedWhenGyroReturnsGreaterThan45(){
        turn.initialize();
        for (int i = 0; i != 4; ++i){
            turn.execute();
            assertFalse(turn.isFinished());
        }
        assertTrue(turn.isFinished());
    }

    @Test
    public void motorStopedWhenEndIsCalled(){
        turn.initialize();
        turn.end();
        verify(leftSide,times(1)).stopMotor();
        verify(rightSide,times(1)).stopMotor();
    }

    @Test
    public void motorStopedWhenInterruptedIsCalled(){
        turn.initialize();
        turn.execute();
        turn.interrupted();
        verify(leftSide,times(1)).stopMotor();
        verify(rightSide,times(1)).stopMotor();
    }

    @Before
    public void setUp(){
        leftSide = mock(SpeedControllerGroup.class);
        rightSide = mock(SpeedControllerGroup.class);
        ADXRS450_Gyro gyro = mock(ADXRS450_Gyro.class);
        when (gyro.getAngle()).thenReturn(0.0).thenReturn(-20.999).thenReturn(-30.0).thenReturn(-40.0).thenReturn(-48.0);
        dt = new DriveTrain(leftSide, rightSide);
        dt.setGyro(gyro);
        turn = new TurnCounterClockwise(dt, 45.0);
    }


    @After
    public void tearDown(){
        turn.close();
    }
}