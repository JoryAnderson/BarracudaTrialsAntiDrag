package com.arcaeic.osrs.BarracudaTrialHelmLock.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.ObjectID;

@RequiredArgsConstructor
@Getter
public enum WindFacilityEnum
{

	WIND_CATCHER(
		new int[]{
			ObjectID.SAILING_WIND_CATCHER_ACTIVATED,
			ObjectID.SAILING_WIND_CATCHER_DEACTIVATED
		}
	),

	GALE_CATCHER(
		new int[]{
			ObjectID.SAILING_GALE_CATCHER_ACTIVATED,
			ObjectID.SAILING_GALE_CATCHER_DEACTIVATED
		}
	),

	CRYSTAL_EXTRACTOR(
		new int[]{
			ObjectID.SAILING_CRYSTAL_EXTRACTOR_ACTIVATED,
			ObjectID.SAILING_CRYSTAL_EXTRACTOR_DEACTIVATED
		}
	);

	private final int[] gameObjectIds;

}
