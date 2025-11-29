package com.smushytaco.expanded_weapon_enchanting
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
@Modmenu(modId = ExpandedWeaponEnchanting.MOD_ID)
@Config(name = ExpandedWeaponEnchanting.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var canUseImpalingOnWeapon = true
    @JvmField
    var canUseDensityOnWeapon = true
    @JvmField
    var canUseBreachOnWeapon = true
    @JvmField
    var canUseWindBurstOnWeapon = true
    @JvmField
    var canMixDifferentWeaponEnchantmentTypes = true
}