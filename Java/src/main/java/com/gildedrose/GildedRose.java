package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            // Guard Clause: Sulfuras does not change in quality or sellIn
            if (item.name.equals(SULFURAS)) {
                continue;
            }

            // Decrement sellIn for all items except Sulfuras
            item.sellIn--;

            // Handle Aged Brie
            if (item.name.equals(AGED_BRIE)) {
                increaseQuality(item);
                if (item.sellIn < 0) {
                    increaseQuality(item);
                }

                continue;
            }

            // Handle Backstage Passes
            if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                    continue;
                }
                increaseQuality(item);
                if (item.sellIn < 10) {
                    increaseQuality(item);
                }
                if (item.sellIn < 5) {
                    increaseQuality(item);
                }
                continue;
            }

            // Handle Normal Items
            decreaseQuality(item);
            if (item.sellIn < 0) {
                decreaseQuality(item);
            }
        }
    }
}
