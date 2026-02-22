package com.arcaeic.osrs.BarracudaTrialHelmLock.util;

import javax.inject.Inject;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarbitID;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BarracudaTrialUtil
{

	public static final int SAILING_BOAT_FACILITY_LOCKEDIN_HELM = 3;

	@SuppressWarnings("BooleanMethodIsAlwaysInverted")
	public static boolean isSailing(Client client)
	{
		return client.getLocalPlayer() != null &&
			!client.getLocalPlayer().getWorldView().isTopLevel();
	}

	public static boolean isInBarracudaTrialAndAtHelm(Client client)
	{
		return isSailing(client)
			&& client.getVarbitValue(VarbitID.SAILING_BT_IN_TRIAL) > 0
			&& client.getVarbitValue(VarbitID.SAILING_BOAT_FACILITY_LOCKEDIN) == SAILING_BOAT_FACILITY_LOCKEDIN_HELM;
	}
}
