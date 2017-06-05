package net.noxumbrarum.lunaeclara.blocks.builder;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.noxumbrarum.lunaeclara.blocks.BlockGeneric;
import net.noxumbrarum.lunaeclara.util.Pair;

public class BlockBuilder
{
	private BlockType blockType = BlockType.SOLID;
	private Material blockMaterial;
	private String registryName;
	private CreativeTabs creativeTabs;
	private SoundType soundType;
	private float hardness;
	
	private Pair<Block, Integer> blockDropQuantity;
	
	public BlockBuilder(String blockRegistryName) {
		this.registryName = blockRegistryName;
	}
	
	
	/**
	 * Sets the type of block.
	 * See BlockType for more info.
	 * @param blockType
	 * @return this for chaining
	 */
	public BlockBuilder setBlockType(BlockType blockType) {
		this.blockType = blockType;
		return this;
	}
	
	/**
	 * Which block/item this block should drop and how many.
	 * @param blockDropQuantity Which block and in which quantity it should drop.
	 * @return this for chaining
	 */
	public BlockBuilder setBlockDropQuantity(Pair<Block, Integer> blockDropQuantity) {
		this.blockDropQuantity = blockDropQuantity;
		return this;
	}
	
	/**
	 * Which block/item this block should drop and how many.
	 * @param blockToDrop Block to drop.
	 * @param blockDropQuantity Quantity to drop.
	 * @return this for chaining.
	 */
	public BlockBuilder setBlockDropQuantity(Block blockToDrop, int blockDropQuantity) {
		this.setBlockDropQuantity(new Pair<Block, Integer>(blockToDrop, blockDropQuantity));
		return this;
	}
	
	/**
	 * Sets the creativeTab this block shall appear in
	 * @param creativeTabs
	 * @return this for chaining.
	 */
	public BlockBuilder setCreativeTab(CreativeTabs creativeTabs) {
		this.creativeTabs = creativeTabs;
		return this;
	}
	
	/**
	 * Set SoundType (footstep sounds) of this block.
	 * @param soundType
	 * @return this for chaining.
	 */
	public BlockBuilder setSoundType(SoundType soundType) {
		this.soundType = soundType;
		return this;
	}
	
	/**
	 * Set the material this block is made of.
	 * @param blockMaterial
	 * @return this for chaining.
	 */
	public BlockBuilder setBlockMaterial(Material blockMaterial) {
		this.blockMaterial = blockMaterial;
		return this;
	}
	
	/**
	 * Set the hardness of a block. 1.0f == stone, 50.0f == obsidian
	 * By default depends on material.
	 * @param hardness
	 * @return this for chaining.
	 */
	public BlockBuilder setHardness(float hardness)
	{
		this.hardness = hardness;
		return this;
	}
	
	/**
	 * Which sound is being played when walking over this block.
	 * @return SoundType
	 */
	public SoundType getSoundType()
	{
		return this.soundType == null ? SoundType.METAL : this.soundType;
	}
	
	/**
	 * Which material is this block made of.
	 * @return Material
	 */
	public Material getBlockMaterial() {
		return this.blockMaterial == null ? Material.CLOTH : this.blockMaterial;
	}
	
	/**
	 * How hard (time to mine) is this block.
	 * @return float
	 */
	public float getHardness()
	{
		return hardness;
	}
	
	/**
	 * Which block/item is being dropped by this block.
	 * @return Block
	 */
	public Block getBlockToDrop() {
		return this.blockDropQuantity.getFirst();
	}
	
	/**
	 * How many drops are being dropped by this block.
	 * @return Integer
	 */
	public int getDropQuantity() {
		return this.blockDropQuantity.getSecond();
	}
	
	/**
	 * Which block/item and how many are being dropped by this block.
	 * @return Pair<Block, Integer>
	 */
	public Pair<Block, Integer> getBlockDropQuantity() {
		return this.blockDropQuantity;
	}
	
	/**
	 * Get registry name of the block.
	 * @return String
	 */
	public String getRegistryName()
	{
		return registryName;
	}
	
	/**
	 * Get type of the block.
	 * @return BlockType
	 */
	public BlockType getBlockType()
	{
		return blockType;
	}
	
	/**
	 * Get Creative Tab this block shall appear in.
	 * @return CreativeTabs
	 */
	public CreativeTabs getCreativeTabs()
	{
		return creativeTabs;
	}
	
	/**
	 * Returns a new instance of BlockType with settings of BlockBuilder provided.
	 * @return BlockGeneric
	 */
	public Block build() {
		switch(this.blockType) {
			case SOLID:
				return BlockGeneric.CREATE(this);
			default:
				break;
		}
		
		return BlockGeneric.CREATE(this);
	}
}
