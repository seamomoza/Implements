### 자동 Implements 등록

---

* #### Features
    * Listener 자동지원
    * Command 자동지원
    * TabCompleter 자동지원

Paper로 코드 작성시 매우 귀찮은 부분이하나 있습니다.

```java
public class Sample implements Listener {
}
```


```java
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Sample(), this);
    }
}

```
위와 같은 코드에선 하나의 리스너 클래스를 추가할 때 마다 메인 클래스에 등록을 해줘야 하는 불편함이 존재합니다 

*Implements*는 이와 같은 문제점을 해결할 수 있도록 새로운 상속 클래스를 제공합니다.

---
아까와 같은 코드가 있다고 생각해 봅시다


이번엔 Implements를 사용하여 작성한 코드입니다.

```java
public class Sample extends Listen {
//리스너 로직
}
```

이런식으로 자동으로 리스너 클래스가 등록되어 메인 클래스에 등록할 필요가 없어집니다.

---

---

사용법

Listener클래스 자동 등록시
```java
implements listener
```

가 아닌

```java
extends listen
```
