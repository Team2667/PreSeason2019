package honeycrisp.cmdutils;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

abstract public class  JoystickCommand extends Command{
    public abstract void addJoystick(XboxController joy);
}