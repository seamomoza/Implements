package Depend;

import Base.Command;
import Base.AutoListener;
import Base.Tab;
import Scan.ClassScanner;
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
        getLogger().info("Implements 활성화됨!");

        // 자동 등록 트리거
        ClassScanner.scanAndRegister("Base", AutoListener.class);
        ClassScanner.scanAndRegister("Base", Command.class);
        ClassScanner.scanAndRegister("Base", Tab.class);
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
