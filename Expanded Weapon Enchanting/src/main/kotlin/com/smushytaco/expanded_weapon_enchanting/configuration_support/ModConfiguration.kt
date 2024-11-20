package com.smushytaco.expanded_weapon_enchanting.configuration_support
import com.smushytaco.expanded_weapon_enchanting.ExpandedWeaponEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
@Config(name = ExpandedWeaponEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    val canUseImpalingOnWeapon = true
    val canUseDensityOnWeapon = true
    val canUseBreachOnWeapon = true
    val canUseWindBurstOnWeapon = true
    val canMixDifferentWeaponEnchantmentTypes = true
}