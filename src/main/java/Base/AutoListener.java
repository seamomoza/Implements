package Base;

import Depend.Implements;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class AutoListener implements Listener {

    static {
        if (Bukkit.getPluginManager().getPlugin("Implements") != null) {
            Implements plugin = Implements.getInstance();
            Bukkit.getPluginManager().registerEvents(newInstanceOfCaller(), plugin);
        }
    }

    private static Listener newInstanceOfCaller() {
        try {
            // 호출한 클래스(extends한 애)를 찾아서 인스턴스화
            String callerClassName = new Throwable().getStackTrace()[2].getClassName();
            System.out.println("현재 호출한 클래스: " + callerClassName);  // 로그 추가
            Class<?> clazz = Class.forName(callerClassName);
            return (Listener) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("자동 등록 실패", e);
        }
    }
}
