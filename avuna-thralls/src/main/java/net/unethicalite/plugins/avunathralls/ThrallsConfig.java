package net.unethicalite.plugins.avunathralls;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("avunathralls")
public interface ThrallsConfig extends Config {
	@ConfigItem(
			keyName = "manualThrallsCastKeybind",
			name = "Manual Trigger",
			description = "Press this key to automatically summon a thralls",
			position = 3
	)
	default Keybind getManualThrallsCastKeybind() {
		return Keybind.NOT_SET;
	}

	@ConfigItem(
			keyName = "autoCastThralls",
			name = "Auto Cast Thralls?",
			description = "Select if you want to the script to automatically cast thralls.",
			position = 1
	)
	default boolean autoCastThralls() {
		return false;
	}

	@ConfigItem(
			keyName = "onlyCastInCombat",
			name = "Only cast in combat?",
			description = "Select if you only want to spawn the Thrall in combat.",
			position = 2
	)
	default boolean onlyCastInCombat() {
		return true;
	}

	@ConfigItem(
			keyName = "thrallType",
			name = "Thrall Type",
			description = "Choose which thrall you want to summon (Highest lvl Thrall by default)",
			position = 0
	)
	default ThrallType getThrallType() {
		return ThrallType.SUPERIOR_ZOMBIE;
	}


}
