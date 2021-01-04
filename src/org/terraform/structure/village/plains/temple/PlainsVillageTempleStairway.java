package org.terraform.structure.village.plains.temple;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.terraform.coregen.PopulatorDataAbstract;
import org.terraform.structure.room.jigsaw.JigsawStructurePiece;
import org.terraform.structure.room.jigsaw.JigsawType;

public class PlainsVillageTempleStairway extends JigsawStructurePiece {

	public PlainsVillageTempleStairway(int widthX, int height, int widthZ, JigsawType type, BlockFace[] validDirs) {
		super(widthX, height, widthZ, type, validDirs);
		
	}

	@Override
	public void build(PopulatorDataAbstract data, Random rand) {
		this.getRoom().fillRoom(data, new Material[] {Material.YELLOW_STAINED_GLASS});
	}

}
