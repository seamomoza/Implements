package Base;

import Depend.Implements;
import org.bukkit.command.CommandExecutor;

public abstract class Command implements CommandExecutor {
    public Command(String commandLabel) {
        Implements.getInstance().registerCommand(commandLabel, this);
    }
}