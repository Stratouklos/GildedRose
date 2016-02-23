package com.leanintuit.gildedrose;

/**
 * This class is provided as an example of how the Inventory and Item classes are called.
 */
public class InventoryClient {


    public static void main(String[] args) {

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)                                // the new item we need to support
        };

        Inventory inventoryManager = new Inventory(items);

        inventoryManager.updateQuality();

        for (Item item : items) {
            System.out.println(String.format("%-42s  Quality: %2d   SellIn: %3d",
                    item.getName(), item.getQuality(), item.getSellIn()));
        }

    }

}
