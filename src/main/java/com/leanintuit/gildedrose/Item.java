/**
 * This class is owned by Rzeds Dreadlurker.
 * DO NOT CHANGE THIS CLASS or he will find you and punish you!
 * Shared code ownership is for the weak.
 */
package com.leanintuit.gildedrose;

public class Item {

	private String name;
	private int sellIn;
	private int quality;

    /**
     * Create the item
     * @param name item name
     * @param sellIn item sell in
     * @param quality item quality
     */
    public Item(String name, int sellIn, int quality) {
		super();
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

    /**
     * Gets the item name
     * @return the item name
     */
    public String getName() {
		return name;
	}

    /**
     * Sets the item name
     * @param name the item name
     */
    public void setName(String name) {
		this.name = name;
	}

    /**
     * Gets the item Sell In
     * @return the item Sell in
     */
    public int getSellIn() {
		return sellIn;
	}

    /**
     * Sets the item sell in
     * @param sellIn the item sell in
     */
    public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

    /**
     * Get the item quality
     * @return item quality
     */
    public int getQuality() {
		return quality;
	}

    /**
     * Set the item quality
     * @param quality item quality
     */
	public void setQuality(int quality) {
		this.quality = quality;
	}
}