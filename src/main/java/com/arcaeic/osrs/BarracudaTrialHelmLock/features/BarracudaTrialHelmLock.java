 package com.arcaeic.osrs.BarracudaTrialHelmLock.features;

import com.arcaeic.osrs.BarracudaTrialHelmLock.model.*;
import com.arcaeic.osrs.BarracudaTrialHelmLock.module.PluginLifecycleComponent;
import com.arcaeic.osrs.BarracudaTrialHelmLock.util.BarracudaTrialUtil;
import com.arcaeic.osrs.BarracudaTrialHelmLock.BarracudaTrialHelmLockConfig;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class BarracudaTrialHelmLock
	implements PluginLifecycleComponent
{

	private final Client client;
	private final BarracudaTrialHelmLockConfig config;

	private Set<Integer> clickableObjects;

	@Inject
	public BarracudaTrialHelmLock(Client client, BarracudaTrialHelmLockConfig config)
	{
		this.client = client;
		this.config = config;
		clickableObjects = reloadClickableObjects();
	}

	private Set<Integer> reloadClickableObjects()
	{
		return Stream.of(
			Arrays.stream(BarracudaTrial.values())
				.map(BarracudaTrial::getGameObjectIds)
				.flatMapToInt(Arrays::stream),
			Arrays.stream(SailFacility.values())
				.map(SailFacility::getGameObjectIds)
				.flatMapToInt(Arrays::stream),
			Arrays.stream(WindFacilityEnum.WIND_CATCHER.getGameObjectIds())
				.filter(s -> config.isClickableWindCatcher()),
			Arrays.stream(WindFacilityEnum.GALE_CATCHER.getGameObjectIds())
				.filter(s -> config.isClickableGaleCatcher()),
			Arrays.stream(WindFacilityEnum.CRYSTAL_EXTRACTOR.getGameObjectIds())
				.filter(s -> config.isClickableCrystalExtractor())
		)
		.flatMapToInt(s -> s)
		.boxed()
		.collect(Collectors.toUnmodifiableSet());
	}

	@Subscribe(priority = -99)
	@SuppressWarnings("unused")
	public void onMenuEntryAdded(MenuEntryAdded e)
	{
		if (!BarracudaTrialUtil.isInBarracudaTrialAndAtHelm(client))
		{
			return;
		}

		if (e.getMenuEntry().getType() != MenuAction.SET_HEADING)
		{
			if (!clickableObjects.contains(e.getIdentifier()))
			{
				e.getMenuEntry().setDeprioritized(true);
			}
		}
	}

	@Override
	public void onConfigChanged(ConfigChanged e)
	{
		log.info("Config change detected: {}: {} -> {}", e.getKey(), e.getOldValue(), e.getNewValue());
		clickableObjects = reloadClickableObjects();
	}
}
