package com.arcaeic.osrs.BarracudaTrialAntiDrag;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class BarracudaTrialAntiDragPluginTest
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(BarracudaTrialAntiDragPlugin.class);
		RuneLite.main(args);
	}
}