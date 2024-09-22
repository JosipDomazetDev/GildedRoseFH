package com.gildedrose;

import com.gildedrose.strategy.ItemNameToStrategyMapping;
import com.gildedrose.strategy.ItemStrategy;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategy strategy = ItemNameToStrategyMapping.fromString(item.name).getStrategy();
            strategy.update(item);
        }
    }
}
