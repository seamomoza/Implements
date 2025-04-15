package Class.Depend;

import Class.Scan.ClassScanner;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Implements extends JavaPlugin {

    private static Implements instance;
    public static Implements getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Implements 플러그인이 활성화되었습니다.");
        // 클래스 스캔하여 리스너 자동 등록
        ClassScanner.scanAndRegister(this);
    }

    // 등록 도우미 메서드들
    public void registerListener(org.bukkit.event.Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    public void registerCommand(String label, CommandExecutor executor) {
        PluginCommand cmd = getCommand(label);
        if (cmd != null) cmd.setExecutor(executor);
    }

    public void registerTabCompleter(String label, TabCompleter completer) {
        PluginCommand cmd = getCommand(label);
        if (cmd != null) cmd.setTabCompleter(completer);
    }
}
