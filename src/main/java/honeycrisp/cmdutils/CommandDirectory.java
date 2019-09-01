package honeycrisp.cmdutils;

import java.util.HashMap;
import edu.wpi.first.wpilibj.command.Command;

public class CommandDirectory {
    private HashMap<Integer,Command> groupCommandCommands = new HashMap<>();
    private HashMap<Integer,Command> buttonCommands = new HashMap<>();
    private HashMap<Integer,JoystickCommand> joyStickCommands = new HashMap<>();

    public void addGrpCmdCommand(int key, Command command){
        groupCommandCommands.put(key, command);
    }

    public void addButtonCommand(int key, Command command){
        buttonCommands.put(key, command);
    }

    public void addJoyStickCommand(int key, JoystickCommand command){
        joyStickCommands.put(key,command);
    }

    public Command getButtonCommand(int key){
        return buttonCommands.get(key);
    }

    public Command getgrpCmdCommand(int key){
        return groupCommandCommands.get(key);
    }

    public JoystickCommand getJoyStickCommand(int key){
        return joyStickCommands.get(key);
    }
}