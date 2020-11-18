package me.bon.badlionplus.module.Misc;

import java.util.ArrayList;
import me.bon.badlionplus.setting.Setting;
import com.mojang.authlib.GameProfile;
import me.bon.badlionplus.module.Category;
import me.bon.badlionplus.module.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public class FakePlayer extends Module {
    public Setting name;

    public FakePlayer() {
		super("FakePlayer", Category.Misc);

        ArrayList<String> list = new ArrayList<>();
        list.add("bon");
        list.add("You");

		rSetting(name = new Setting("Name", this, "bon", list, "name"));
	}

	private EntityOtherPlayerMP _fakePlayer;

    @Override
    public void onEnable()
    {
        super.onEnable();
        _fakePlayer = null;

        if (mc.world == null)
        {
            this.toggle();
            return;
        }

        String s = "";

        switch (name.getValString()) {
            case "bon":
                s = "bon";
                break;
            case "You":
                s = mc.player.getName();
                break;
        }

        _fakePlayer = new EntityOtherPlayerMP(mc.world, new GameProfile(mc.player.getUniqueID(), s));

        mc.world.addEntityToWorld(_fakePlayer.getEntityId(), _fakePlayer);
        _fakePlayer.attemptTeleport(mc.player.posX, mc.player.posY, mc.player.posZ); // moves fake player to your current position
    }

    @Override
    public void onDisable()
    {
    	if(!(mc.world == null)) {
    		mc.world.removeEntity(_fakePlayer);
    	}
    }
}
