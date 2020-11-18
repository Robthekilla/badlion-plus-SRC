package me.bon.badlionplus.module.Misc;

import me.bon.badlionplus.BadlionRPC;
import me.bon.badlionplus.command.Command;
import me.bon.badlionplus.module.Module;
import me.bon.badlionplus.BadlionMod;
import me.bon.badlionplus.module.Category;

public class RpcModule extends Module {
    public RpcModule() {
        super("DiscordRPC", Category.Misc);
    }

    public void onEnable(){
        BadlionRPC.init();
    }

    public void onDisable(){
        BadlionRPC.init();
    }
}
