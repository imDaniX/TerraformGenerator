package org.terraform.coregen;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.loot.LootTable;

public enum TerraLootTable {
    EMPTY("empty"), //Not a valid key
    SPAWN_BONUS_CHEST("chests/spawn_bonus_chest"),
    END_CITY_TREASURE("chests/end_city_treasure"),
    SIMPLE_DUNGEON("chests/simple_dungeon"),
    VILLAGE_WEAPONSMITH("chests/village/village_weaponsmith"),
    VILLAGE_TOOLSMITH("chests/village/village_toolsmith"),
    VILLAGE_ARMORER("chests/village/village_armorer"),
    VILLAGE_CARTOGRAPHER("chests/village/village_cartographer"),
    VILLAGE_MASON("chests/village/village_mason"),
    VILLAGE_SHEPHERD("chests/village/village_shepherd"),
    VILLAGE_BUTCHER("chests/village/village_butcher"),
    VILLAGE_FLETCHER("chests/village/village_fletcher"),
    VILLAGE_FISHER("chests/village/village_fisher"),
    VILLAGE_TANNERY("chests/village/village_tannery"),
    VILLAGE_TEMPLE("chests/village/village_temple"),
    VILLAGE_DESERT_HOUSE("chests/village/village_desert_house"),
    VILLAGE_PLAINS_HOUSE("chests/village/village_plains_house"),
    VILLAGE_TAIGA_HOUSE("chests/village/village_taiga_house"),
    VILLAGE_SNOWY_HOUSE("chests/village/village_snowy_house"),
    VILLAGE_SAVANNA_HOUSE("chests/village/village_savanna_house"),
    ABANDONED_MINESHAFT("chests/abandoned_mineshaft"),
    NETHER_BRIDGE("chests/nether_bridge"),
    STRONGHOLD_LIBRARY("chests/stronghold_library"),
    STRONGHOLD_CROSSING("chests/stronghold_crossing"),
    STRONGHOLD_CORRIDOR("chests/stronghold_corridor"),
    DESERT_PYRAMID("chests/desert_pyramid"),
    JUNGLE_TEMPLE("chests/jungle_temple"),
    JUNGLE_TEMPLE_DISPENSER("chests/jungle_temple_dispenser"),
    IGLOO_CHEST("chests/igloo_chest"),
    WOODLAND_MANSION("chests/woodland_mansion"),
    UNDERWATER_RUIN_SMALL("chests/underwater_ruin_small"),
    UNDERWATER_RUIN_BIG("chests/underwater_ruin_big"),
    BURIED_TREASURE("chests/buried_treasure"),
    SHIPWRECK_MAP("chests/shipwreck_map"),
    SHIPWRECK_SUPPLY("chests/shipwreck_supply"),
    SHIPWRECK_TREASURE("chests/shipwreck_treasure"),
    PILLAGER_OUTPOST("chests/pillager_outpost"),
    BASTION_TREASURE("chests/bastion_treasure"),
    BASTION_OTHER("chests/bastion_other"),
    BASTION_BRIDGE("chests/bastion_bridge"),
    BASTION_HOGLIN_STABLE("chests/bastion_hoglin_stable"),
    ANCIENT_CITY("chests/ancient_city"),
    ANCIENT_CITY_ICE_BOX("chests/ancient_city_ice_box"),
    RUINED_PORTAL("chests/ruined_portal"),
    SHEEP_WHITE("entities/sheep/white"),
    SHEEP_ORANGE("entities/sheep/orange"),
    SHEEP_MAGENTA("entities/sheep/magenta"),
    SHEEP_LIGHT_BLUE("entities/sheep/light_blue"),
    SHEEP_YELLOW("entities/sheep/yellow"),
    SHEEP_LIME("entities/sheep/lime"),
    SHEEP_PINK("entities/sheep/pink"),
    SHEEP_GRAY("entities/sheep/gray"),
    SHEEP_LIGHT_GRAY("entities/sheep/light_gray"),
    SHEEP_CYAN("entities/sheep/cyan"),
    SHEEP_PURPLE("entities/sheep/purple"),
    SHEEP_BLUE("entities/sheep/blue"),
    SHEEP_BROWN("entities/sheep/brown"),
    SHEEP_GREEN("entities/sheep/green"),
    SHEEP_RED("entities/sheep/red"),
    SHEEP_BLACK("entities/sheep/black"),
    FISHING("gameplay/fishing"),
    FISHING_JUNK("gameplay/fishing/junk"),
    FISHING_TREASURE("gameplay/fishing/treasure"),
    FISHING_FISH("gameplay/fishing/fish"),
    CAT_MORNING_GIFT("gameplay/cat_morning_gift"),
    ARMORER_GIFT("gameplay/hero_of_the_village/armorer_gift"),
    BUTCHER_GIFT("gameplay/hero_of_the_village/butcher_gift"),
    CARTOGRAPHER_GIFT("gameplay/hero_of_the_village/cartographer_gift"),
    CLERIC_GIFT("gameplay/hero_of_the_village/cleric_gift"),
    FARMER_GIFT("gameplay/hero_of_the_village/farmer_gift"),
    FISHERMAN_GIFT("gameplay/hero_of_the_village/fisherman_gift"),
    FLETCHER_GIFT("gameplay/hero_of_the_village/fletcher_gift"),
    LEATHERWORKER_GIFT("gameplay/hero_of_the_village/leatherworker_gift"),
    LIBRARIAN_GIFT("gameplay/hero_of_the_village/librarian_gift"),
    MASON_GIFT("gameplay/hero_of_the_village/mason_gift"),
    SHEPHERD_GIFT("gameplay/hero_of_the_village/shepherd_gift"),
    TOOLSMITH_GIFT("gameplay/hero_of_the_village/toolsmith_gift"),
    WEAPONSMITH_GIFT("gameplay/hero_of_the_village/weaponsmith_gift"),
    SNIFFER_DIGGING("gameplay/sniffer_digging"),
    PIGLIN_BARTERING("gameplay/piglin_bartering"),
    DESERT_WELL_ARCHAEOLOGY("archaeology/desert_well"),
    DESERT_PYRAMID_ARCHAEOLOGY("archaeology/desert_pyramid"),
    TRAIL_RUINS_ARCHAEOLOGY_COMMON("archaeology/trail_ruins_common"),
    TRAIL_RUINS_ARCHAEOLOGY_RARE("archaeology/trail_ruins_rare"),
    OCEAN_RUIN_WARM_ARCHAEOLOGY("archaeology/ocean_ruin_warm"),
    OCEAN_RUIN_COLD_ARCHAEOLOGY("archaeology/ocean_ruin_cold"),
    ;

    @SuppressWarnings("unused")
    private final String key;

    TerraLootTable(String key) {
        this.key = key;
    }

    public LootTable bukkit(){
        return Bukkit.getLootTable(NamespacedKey.minecraft(this.key));
    }
}
