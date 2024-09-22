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
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        // Guard Clause: Sulfuras does not change in quality or sellIn
        if (item.name.equals(SULFURAS)) {
            return;
        }

        item.sellIn--;

        switch (item.name) {
            case AGED_BRIE:
                updateAgedBrie(item);
                break;

            case BACKSTAGE_PASSES:
                updateBackstage(item);
                break;

            default:
                updateNormalItem(item);
                break;
        }
    }

    private void updateNormalItem(Item item) {
        // Handle Normal Items
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void updateBackstage(Item item) {
        // Handle Backstage Passes
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            increaseQuality(item);
            if (item.sellIn < 10) {
                increaseQuality(item);
            }
            if (item.sellIn < 5) {
                increaseQuality(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        // Handle Aged Brie
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}
