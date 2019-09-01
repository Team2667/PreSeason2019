package honeycrisp.cmdutils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

abstract public class  JoystickCommand extends Command{
    public abstract void addJoystick(GenericHID joy);
}