package Class.Base;

import Class.Depend.Implements;
import org.bukkit.command.CommandExecutor;

public abstract class Command implements CommandExecutor {
    public Command(String commandLabel) {
        // 커맨드 레이블을 주면 자동으로 등록
        Implements.getInstance().registerCommand(commandLabel, this);
    }
}
