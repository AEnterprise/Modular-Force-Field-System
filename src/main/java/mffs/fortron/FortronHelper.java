package mffs.fortron;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

/**
 * A class with useful functions related to Fortron.
 * 
 * @author Calclavia
 * 
 */
public class FortronHelper
{
	public static Fluid FLUID_FORTRON;
	public static FluidStack FLUIDSTACK_FORTRON;

	public static FluidStack getFortron(int amount)
	{
		FluidStack stack = FortronHelper.FLUIDSTACK_FORTRON.copy();
		stack.amount = amount;
		return stack;
	}

	public static int getAmount(FluidStack liquidStack)
	{
		if (liquidStack != null)
		{
			return liquidStack.amount;
		}
		return 0;
	}

	public static int getAmount(FluidTank fortronTank)
	{
		if (fortronTank != null)
		{
			return getAmount(fortronTank.getFluid());
		}

		return 0;
	}
}
