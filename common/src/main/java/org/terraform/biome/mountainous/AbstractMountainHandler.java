package org.terraform.biome.mountainous;

import java.util.Random;

import org.terraform.biome.BiomeBank;
import org.terraform.biome.BiomeHandler;
import org.terraform.biome.BiomeSection;
import org.terraform.biome.BiomeSubSection;
import org.terraform.biome.BiomeType;
import org.terraform.coregen.HeightMap;
import org.terraform.data.SimpleLocation;
import org.terraform.data.TerraformWorld;
import org.terraform.main.config.TConfigOption;
import org.terraform.utils.GenUtils;

public abstract class AbstractMountainHandler extends BiomeHandler {

	protected double getPeakMultiplier(BiomeSection section, Random sectionRandom)
	{
		//this is positive as this is a mountain.
		//double elevation = section.getElevation();
		double lowerBound = 1.4;
		double upperBound = 1.7;
		
		//boolean surroundedByMountains = true;
		
		float mt =  TConfigOption.BIOME_MOUNTAINOUS_THRESHOLD.getFloat();
		//float hmt =  TConfigOption.BIOME_HIGH_MOUNTAINOUS_THRESHOLD.getFloat();
		
		//Check direct faces, not diagonals
		for(int[] rel:new int[][] {{1,0},{-1,0},{0,1},{0,-1}}) {
			int nx = rel[0];
			int nz = rel[1];
			if(section.getRelative(nx, nz).getOceanLevel() >= mt) {
				//surroundedByMountains = false;
				lowerBound = 1.2;
				upperBound = 1.4;
				break;
			}
		}
		
		return GenUtils.randDouble(sectionRandom, lowerBound, upperBound);
	}
	
	/**
	 * Mountain height calculation works by taking the BiomeSection
	 * center, then multiplying current height to peak at that location.
	 */
	@Override
    public double calculateHeight(TerraformWorld tw, int x, int z) {
    	
        double height = HeightMap.CORE.getHeight(tw, x, z);//HeightMap.MOUNTAINOUS.getHeight(tw, x, z); //Added here
        
        //Let mountains cut into adjacent sections.
        double maxMountainRadius = ((double) BiomeSection.sectionWidth);
        //Double attrition height
        height += HeightMap.ATTRITION.getHeight(tw, x, z);
        
        BiomeSection sect = BiomeBank.getBiomeSectionFromBlockCoords(tw, x, z);
        if(sect.getBiomeBank().getType() != BiomeType.MOUNTAINOUS) {
        	sect = BiomeSection.getMostDominantSection(tw, x, z);
        }
        
        Random sectionRand = sect.getSectionRandom();
        double maxPeak = getPeakMultiplier(sect, sectionRand);
        
        //Let's just not offset the peak. This seems to give a better result.
        SimpleLocation mountainPeak = sect.getCenter();
        
        double distFromPeak = (1.42*maxMountainRadius)-Math.sqrt(
        		Math.pow(x-mountainPeak.getX(), 2)+Math.pow(z-mountainPeak.getZ(), 2)
        		);

        double heightMultiplier = maxPeak*(distFromPeak/maxMountainRadius);
        double minMultiplier = 1;
        BiomeSubSection subSect = sect.getSubSection(x, z);

		float mt =  TConfigOption.BIOME_MOUNTAINOUS_THRESHOLD.getFloat();
        switch(subSect) {
		case NEGATIVE_X:
			if(sect.getRelative(-1, 0).getOceanLevel() >= mt)
				minMultiplier = 1.25;
			break;
		case NEGATIVE_Z:
			if(sect.getRelative(0, -1).getOceanLevel() >= mt)
				minMultiplier = 1.25;
			break;
		case POSITIVE_X:
			if(sect.getRelative(1, 0).getOceanLevel() >= mt)
				minMultiplier = 1.25;
			break;
		case POSITIVE_Z:
			if(sect.getRelative(1, 0).getOceanLevel() >= mt)
				minMultiplier = 1.25;
			break;
		case NONE:
			minMultiplier = 1.7;
			break;
        
        }
        
        if(heightMultiplier < minMultiplier) heightMultiplier = minMultiplier;
        
        height = height*heightMultiplier;
        
        //If the height is too high, just force it to smooth out
        if (height > 200) height = 200 + (height - 200) * 0.5;
        if (height > 230) height = 230 + (height - 230) * 0.3;
        if (height > 240) height = 240 + (height - 240) * 0.1;
        if (height > 250) height = 250 + (height - 250) * 0.05;
        
        return height;
    }
	
	
}
