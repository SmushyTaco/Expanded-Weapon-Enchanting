package com.smushytaco.expanded_weapon_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_weapon_enchanting.ExpandedWeaponEnchanting;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(DamageEnchantment.class)
public abstract class WeaponEnchantmentTypesCanBeMixed {
    @ModifyReturnValue(method = "canAccept", at = @At("RETURN"))
    @SuppressWarnings("unused")
    private boolean hookCanAccept(boolean original, Enchantment other) { return ExpandedWeaponEnchanting.INSTANCE.getConfig().getCanMixDifferentWeaponEnchantmentTypes() || original; }
}