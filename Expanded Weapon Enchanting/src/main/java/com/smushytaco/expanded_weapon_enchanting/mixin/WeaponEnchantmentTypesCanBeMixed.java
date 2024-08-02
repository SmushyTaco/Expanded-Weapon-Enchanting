package com.smushytaco.expanded_weapon_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_weapon_enchanting.ExpandedWeaponEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Enchantment.class)
public abstract class WeaponEnchantmentTypesCanBeMixed {
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean hookIsAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (ExpandedWeaponEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.IMPALING)) {
            if (!ExpandedWeaponEnchanting.INSTANCE.getConfig().getCanMixDifferentWeaponEnchantmentTypes() || !(stack.getItem() instanceof SwordItem)) return original;
            return true;
        }
        return original;
    }
    @ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second) {
        if (!ExpandedWeaponEnchanting.INSTANCE.getConfig().getCanMixDifferentWeaponEnchantmentTypes()) return original;
        if (first.matchesKey(Enchantments.SHARPNESS)) {
            if (second.matchesKey(Enchantments.SMITE) || second.matchesKey(Enchantments.BANE_OF_ARTHROPODS) || second.matchesKey(Enchantments.IMPALING)) return true;
        } else if (first.matchesKey(Enchantments.SMITE)) {
            if (second.matchesKey(Enchantments.SHARPNESS) || second.matchesKey(Enchantments.BANE_OF_ARTHROPODS) || second.matchesKey(Enchantments.IMPALING)) return true;
        } else if (first.matchesKey(Enchantments.BANE_OF_ARTHROPODS)) {
            if (second.matchesKey(Enchantments.SHARPNESS) || second.matchesKey(Enchantments.SMITE) || second.matchesKey(Enchantments.IMPALING)) return true;
        } else if (first.matchesKey(Enchantments.IMPALING)) {
            if (second.matchesKey(Enchantments.SHARPNESS) || second.matchesKey(Enchantments.SMITE) || second.matchesKey(Enchantments.BANE_OF_ARTHROPODS)) return true;
        } else if (second.matchesKey(Enchantments.SHARPNESS)) {
            if (first.matchesKey(Enchantments.SMITE) || first.matchesKey(Enchantments.BANE_OF_ARTHROPODS) || first.matchesKey(Enchantments.IMPALING)) return true;
        } else if (second.matchesKey(Enchantments.SMITE)) {
            if (first.matchesKey(Enchantments.SHARPNESS) || first.matchesKey(Enchantments.BANE_OF_ARTHROPODS) || first.matchesKey(Enchantments.IMPALING)) return true;
        } else if (second.matchesKey(Enchantments.BANE_OF_ARTHROPODS)) {
            if (first.matchesKey(Enchantments.SHARPNESS) || first.matchesKey(Enchantments.SMITE) || first.matchesKey(Enchantments.IMPALING)) return true;
        } else if (second.matchesKey(Enchantments.IMPALING)) {
            if (first.matchesKey(Enchantments.SHARPNESS) || first.matchesKey(Enchantments.SMITE) || first.matchesKey(Enchantments.BANE_OF_ARTHROPODS)) return true;
        }
        return original;
    }
}