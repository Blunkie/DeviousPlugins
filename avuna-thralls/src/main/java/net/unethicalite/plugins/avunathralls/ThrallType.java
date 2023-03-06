package net.unethicalite.plugins.avunathralls;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.unethicalite.api.magic.Spell;
import net.unethicalite.api.magic.SpellBook;

@Getter
public enum ThrallType {

	LESSER_GHOST(SpellBook.Necromancy.RESURRECT_LESSER_GHOST),
	LESSER_SKELETON(SpellBook.Necromancy.RESURRECT_LESSER_SKELETON),
	LESSER_ZOMBIE(SpellBook.Necromancy.RESURRECT_LESSER_ZOMBIE),
	SUPERIOR_GHOST(SpellBook.Necromancy.RESURRECT_SUPERIOR_GHOST),
	SUPERIOR_SKELETON(SpellBook.Necromancy.RESURRECT_SUPERIOR_SKELETON),
	SUPERIOR_ZOMBIE(SpellBook.Necromancy.RESURRECT_SUPERIOR_ZOMBIE),
	GREATER_GHOST(SpellBook.Necromancy.RESURRECT_GREATER_GHOST),
	GREATER_SKELETON(SpellBook.Necromancy.RESURRECT_GREATER_SKELETON),
	GREATER_ZOMBIE(SpellBook.Necromancy.RESURRECT_GREATER_ZOMBIE);

	private final Spell spellToCast;

	private ThrallType(Spell spellToCast) {
		this.spellToCast = spellToCast;
	}
}