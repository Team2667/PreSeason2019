package honeycrisp.cmdutils;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import static org.junit.Assert.*;

public class CommandGroupUtilsTest{

    public class TestCommand extends Command{
        TestCommand (Subsystem sys){
            requires(sys);
        }
        
        public boolean isFinished(){
            return true;
        }
    }

    private Command one, two;
    private Subsystem subsystem1, subsystem2;

    @Before
    public void setUp(){
        subsystem1 = mock(Subsystem.class);
        subsystem2 = mock(Subsystem.class);
        
        one = new TestCommand(subsystem1);
        
        two = new TestCommand(subsystem2);
    }

    @Test
    public void createSequencialCommandGroupDoesNotIncludeNulls(){
        CommandGroup cg = (CommandGroup)CommandGroupUtils.createSequencialCommandGroup(one, null);
        assertTrue(cg.doesRequire(subsystem1));
        assertFalse(cg.doesRequire(subsystem2));
    }

    @Test
    public void createParellelCommandGroupDoesNotIncludeNulls(){
        CommandGroup cg = (CommandGroup)CommandGroupUtils.createParellelCommandGroup(one, null);
        assertTrue(cg.doesRequire(subsystem1));
        assertFalse(cg.doesRequire(subsystem2));
    }

    @Test
    public void createSequencialCommandGroupAddsAllTheCommands(){
        CommandGroup cg = (CommandGroup)CommandGroupUtils.createSequencialCommandGroup(one,two);
        assertTrue(cg.doesRequire(subsystem1));
        assertTrue(cg.doesRequire(subsystem2));
    }

    @Test
    public void createParellelCommandGroupAddsAllTheCommands(){
        CommandGroup cg = (CommandGroup)CommandGroupUtils.createParellelCommandGroup(one,two);
        assertTrue(cg.doesRequire(subsystem1));
        assertTrue(cg.doesRequire(subsystem2));
    }
}