package honeycrisp.cmdutils;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.command.Command;

public class CommandDirectoryTest {

    Command cmd1;
    JoystickCommand joyCmd;
    CommandDirectory directory;

    @Before
    public void setUp(){
        directory = new CommandDirectory();
        cmd1 = mock(Command.class);
        joyCmd = mock(JoystickCommand.class);
    }

    @Test
    public void canRetreiveButtonCommandAfterAddingIt(){
        directory.addButtonCommand(1, cmd1);
        assertTrue(cmd1 == directory.getButtonCommand(1));
    }

    @Test
    public void getButtonCommandReturnsNullWhenNotPresent(){
        directory.addButtonCommand(1,cmd1);
        assertNull(directory.getButtonCommand(1000));
    }

    @Test
    public void canRetreiveGroupStepCommandAfterAddingIt(){
        directory.addGroupStepCommand(1, cmd1);
        assertTrue(cmd1 == directory.getGroupStepCommand(1));
    }

    @Test
    public void getGroupStepCommandReturnsNullWhenNotPresent(){
        directory.addGroupStepCommand(1,cmd1);
        assertNull(directory.getGroupStepCommand(1000));
    }

    @Test
    public void canRetreivJoyStickCommandAfterAddingIt(){
        directory.addJoyStickCommand(1, joyCmd);
        assertTrue(joyCmd == directory.getJoyStickCommand(1));
    }

    @Test
    public void getJoyStickCommandReturnsNullWhenNotPresent(){
        directory.addJoyStickCommand(1,joyCmd);
        assertNull(directory.getJoyStickCommand(1000));
    }
}