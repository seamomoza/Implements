package Scan;

import Depend.Implements;
import org.reflections.Reflections;
import java.util.Set;

public class ClassScanner {

    public static void scanAndRegister(String basePackage, Class<?> superType) {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<? extends Object>> subtypes = reflections.getSubTypesOf((Class<Object>) superType);

        Implements.getInstance().getLogger().info("[Implements] 스캔된 클래스:");
        for (Class<?> clazz : subtypes) {
            Implements.getInstance().getLogger().info("클래스 발견: " + clazz.getName());  // 여기에 로그 추가
            try {
                clazz.getDeclaredConstructor().newInstance(); // 기본 생성자 호출
            } catch (Exception e) {
                Implements.getInstance().getLogger().warning("[Implements] 클래스 인스턴스화 실패: " + clazz.getName());
                e.printStackTrace();
            }
        }
    }
}