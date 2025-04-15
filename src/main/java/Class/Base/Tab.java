package Class.Base;

import Class.Depend.Implements;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class Tab implements TabCompleter {
    public Tab(String commandLabel) {
        // TabCompleter도 자동 등록
        Implements.getInstance().registerTabCompleter(commandLabel, this);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // 기본 구현 (필요시 오버라이드해서 사용)
        return null;
    }
}
