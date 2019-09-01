package honeycrisp.cmdutils;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroupCommandUtils  {

    public static Command createSequencialCommandGroup(Command ... commands){
        CommandGroup cg = new CommandGroup();
        List<Command> cmdList = Arrays.asList(commands);
        cmdList.stream().filter(c -> c != null).forEach(c -> cg.addSequential(c));

        return cg;
    }

    public static  Command createParellelCommandGroup(Command ... commands){
        CommandGroup cg = new CommandGroup();
        List<Command> cmdList = Arrays.asList(commands);
        cmdList.stream().filter(c -> c != null).forEach(c -> cg.addParallel(c));

        return cg;
    }
}