package com.smushytaco.expanded_weapon_enchanting.mixin;
import com.smushytaco.expanded_weapon_enchanting.ExpandedWeaponEnchanting;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(DamageEnchantment.class)
public abstract class WeaponEnchantmentTypesCanBeMixed {
    @Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
    private void hookCanAccept(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        if (!ExpandedWeaponEnchanting.INSTANCE.getConfig().getCanMixDifferentWeaponEnchantmentTypes()) return;
        cir.setReturnValue(true);
    }
}