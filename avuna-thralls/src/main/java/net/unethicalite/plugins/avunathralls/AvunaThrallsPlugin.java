package net.unethicalite.plugins.avunathralls;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.game.Game;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.magic.Magic;
import net.unethicalite.api.magic.Spell;
import net.unethicalite.client.Static;
import org.pf4j.Extension;

@PluginDescriptor(name = "Avuna Thralls", enabledByDefault = false)
@Extension
@Slf4j
public class AvunaThrallsPlugin extends Plugin {
	@Inject
	private ThrallsConfig config;

	@Inject
	private Client client;

	@Provides
	public ThrallsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ThrallsConfig.class);
	}

	@Subscribe
	public void onGameTick(GameTick gameTickEvent) {
		if(!Game.isLoggedIn()) {
			return;
		}
		if(!config.autoCastThralls()) {
			return;
		}
		Spell spell = config.getThrallType().getSpellToCast();
		if(!spell.canCast()) {
			return;
		}
		if(!Inventory.contains("Book of the dead")) {
			return;
		}
		final boolean isThrallSpawned = client.getVarbitValue(Varbits.RESURRECT_THRALL) == 1;
		if(isThrallSpawned) {
			return;
		}
		Magic.cast(spell);
	}

}
