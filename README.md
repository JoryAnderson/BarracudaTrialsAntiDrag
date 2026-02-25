# Barracuda Trial Helm Lock

Customizable menu swaps that mitigate misclicks which cause the player to leave the ship's helm or otherwise prevent navigation during Barracuda Trials. 

The plugin only takes effect when all three of the below requirements are met:

* The player is sailing (i.e., on their player-owned ship)
* AND is actively in a Barracuda Trial
* AND is actively manning their helm

## How it works

When the above criteria is met, only entity IDs in the allowlist will have their Menu Entries prioritized. This list includes:
* Barracuda Trial-related Objects and NPCs. Such as shipments, balloon toads, jubbly nests, crystallized helm, etc.
* The mast and sail on the player-owned ship.
* Wind facilities on the player-owned ship. This is configurable by the player.

Otherwise, all other ship facilities and world objects will have their menu entries deprioritized to prevent misclicks 
during Barracuda Trials. **Players can still shift-right-click to access these menu entries.**

## Configuration

Current configuration allows for:
* Wind Catcher facility menu entries (**default: enabled**)
* Gale Catcher facility menu entries (**default: enabled**)
* Crystal Extractor facility menu entries (default: disabled)