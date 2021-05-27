package com.smushytaco.expanded_weapon_enchanting.configuration_support
import com.smushytaco.expanded_weapon_enchanting.ExpandedWeaponEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = ExpandedWeaponEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is yes. If set to yes you'll be able to mix all different weapon enchantment types on the same weapon. If set to no you won't be able to.")
    val canMixDifferentWeaponEnchantmentTypes = true
}