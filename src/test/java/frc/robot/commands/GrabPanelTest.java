package frc.robot.commands;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.subsystems.MockPanelGrabberBuilder;

public class GrabPanelTest {
    DoubleSolenoid mockedDoubleSolenoid;
    GrabPanel cmd;

    @Before
    public void setUp(){
        MockPanelGrabberBuilder builder = new MockPanelGrabberBuilder();
        builder.addSolenoid("hatch", 0, 1);
        cmd = new GrabPanel(builder.build());
        mockedDoubleSolenoid = builder.getMockedSolinoid();
    }

    @Test
    public void initializeCauseTheRamToRetract(){
        cmd.initialize();
        verify(mockedDoubleSolenoid,times(1)).set(DoubleSolenoid.Value.kForward);
    }

    @Test
    public void isFinishedShouldAlwaysReturnTrue(){
        assertTrue(cmd.isFinished());
    }
}