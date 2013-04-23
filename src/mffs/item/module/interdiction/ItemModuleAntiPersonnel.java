package mffs.item.module.interdiction;

import mffs.ModularForceFieldSystem;
import mffs.Settings;
import mffs.api.security.IInterdictionMatrix;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

public class ItemModuleAntiPersonnel extends ItemModuleInterdictionMatrix
{
	public ItemModuleAntiPersonnel(int i)
	{
		super(i, "moduleAntiPersonnel");
	}

	@Override
	public boolean onDefend(IInterdictionMatrix defenseStation, EntityLiving entityLiving)
	{
		boolean hasPermission = false;

		if (!hasPermission && entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entityLiving;
			player.addChatMessage("[" + defenseStation.getInvName() + "] Fairwell.");

			for (int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				defenseStation.mergeIntoInventory(player.inventory.getStackInSlot(i));
				player.inventory.setInventorySlotContents(i, null);
			}

			player.attackEntityFrom(ModularForceFieldSystem.damagefieldShock, Integer.MAX_VALUE);
			defenseStation.requestFortron(Settings.INTERDICTION_MURDER_ENERGY, false);
		}

		return false;
	}
}