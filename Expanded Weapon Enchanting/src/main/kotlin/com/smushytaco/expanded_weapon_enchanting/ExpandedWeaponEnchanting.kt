package com.smushytaco.expanded_weapon_enchanting
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.core.Holder
import net.minecraft.core.RegistryAccess
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import kotlin.jvm.optionals.getOrNull
object ExpandedWeaponEnchanting : ModInitializer {
    const val MOD_ID = "expanded_weapon_enchanting"
    val config = ModConfig.createAndLoad()
    private var dynamicRegistryManager: RegistryAccess? = null
    override fun onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register { server -> dynamicRegistryManager = server.registryAccess() }
    }
    fun isWeapon(item: ItemStack) = dynamicRegistryManager?.lookupOrThrow(Registries.ITEM)?.getOrThrow(ItemTags.WEAPON_ENCHANTABLE)?.contains(item.itemHolder) ?: false
    fun isSameEnchantment(enchantment: Enchantment, enchantmentRegistryKey: ResourceKey<Enchantment>) = dynamicRegistryManager?.lookup(Registries.ENCHANTMENT)?.getOrNull()?.wrapAsHolder(enchantment)?.`is`(enchantmentRegistryKey) ?: false
    fun canCombineEnchantments(first: Holder<Enchantment>, second: Holder<Enchantment>, enchantments: Set<ResourceKey<Enchantment>>) = enchantments.any { first.`is`(it) } && enchantments.any { second.`is`(it) } && (second.unwrapKey().getOrNull()?.let { !first.`is`(it) } ?: true)
}