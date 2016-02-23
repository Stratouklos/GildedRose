package com.leanintuit.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InventoryViceTest {

	@Test
	public void test() {
		String[] possibleItems = new String[] {
				"Sulfuras, Hand of Ragnaros",
				"Aged Brie",
				"Backstage passes to a TAFKAL80ETC concert",
				"Elixir of the Mongoose",
				"arbitrary item"
		};
		
		Item[] items = makeItems(possibleItems);
		
		Inventory sut = new Inventory(items);

		StringBuilder results = new StringBuilder();
		
		for (int reps = 0; reps < 100; reps++) {
			sut.updateQuality();
			appendsItemsToResults(items, results);
		}
		
		int hashCode = results.toString().hashCode();
		// change this value if you change the code.
		// run the tests again and get the new expected values
		int expectedHashCode = -1477337066;

//		System.out.println("hashcode=" + hashCode);
		assertEquals(expectedHashCode, hashCode);
		
	}

	private void appendsItemsToResults(Item[] items, StringBuilder results) {
		for (Item item : items) {
			results.append(item.getName() + "| quality:" + item.getQuality() + "| sellIn:" + item.getSellIn() + "\n");
		}
		results.append("\n");
	}

	private Item[] makeItems(String[] possibleItems) {
		List<Item> itemList = new ArrayList<Item>();

		for (int qualityIndex = 0; qualityIndex < 50; qualityIndex++) {
			for (int sellInIndex = -5; sellInIndex < 20; sellInIndex++) {
				for (String itemName : possibleItems) {
					itemList.add(new Item(itemName, qualityIndex, sellInIndex));
				}
			}
		}
		
		return convertToArray(itemList);
	}

	private Item[] convertToArray(List<Item> itemList) {
		return (Item[]) itemList.toArray(new Item[itemList.size()]);
	}

}
