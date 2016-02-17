package com.leanintuit.gildedrose;

import java.util.ArrayList;
import java.util.List;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.FileLauncherReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

public class InventoryApprovalTest {

	// Uncomment the following line to get a visual diff tool:
	//   Windows: Tortoise, BeyondCompare or WinMerge must be installed
	//   Mac:     DiffMerge, Kaleidoscope or TkDiff must be installed
	// @UseReporter(DiffReporter.class)
	@UseReporter(FileLauncherReporter.class)
	@Test
	public void test() throws Exception {
		Item[] items = makeItems();
		Inventory sut = new Inventory(items);

		StringBuilder results = new StringBuilder();

		for (int day = 1; day <= 100; day++) {
			results.append(resultsForDay(day, items));
			sut.updateQuality();
		}

		Approvals.verify(results.toString());
	}
	
	private Item[] makeItems() {
		String[] names = new String[] {
				"+5 Dexterity Vest",
				"Aged Brie",
				"Backstage passes to a TAFKAL80ETC concert",
				"Elixir of the Mongoose",
				"arbitrary item"
		};
		List<Item> itemList = new ArrayList<Item>();
		
		for (int qualityIndex = 0; qualityIndex <= 50; qualityIndex += 25) {
			for (String name : names) {
				itemList.add(new Item(name, 20, qualityIndex));
			}
		}
		itemList.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		return convertToArray(itemList);
	}
	
	private Item[] convertToArray(List<Item> itemList) {
		return itemList.toArray(new Item[itemList.size()]);
	}

	private String resultsForDay(int day, Item[] items) {
		StringBuilder results = new StringBuilder();
		
		results.append("Day ").append(day).append("\n");
		
		for (Item item : items) {
			results.append(resultsForItem(item));
		}
		results.append("\n");
		
		return results.toString();
	}

	private String resultsForItem(Item item) {
		return String.format("%-42s  Quality: %2d   SellIn: %3d\n",
				item.getName(), item.getQuality(), item.getSellIn());
	}
}
