package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        increaseQuality(item);
        item.sellIn--;

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}
