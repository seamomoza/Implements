package Example;

import Base.AutoListener;
import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Example extends AutoListener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("산치핀치산치핀치");
    }
    @EventHandler
    public void Jump(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("점프!");
    }
}
