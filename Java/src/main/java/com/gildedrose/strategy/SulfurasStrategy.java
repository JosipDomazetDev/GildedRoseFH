package com.gildedrose.strategy;

import com.gildedrose.Item;

public class SulfurasStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        // "Sulfuras" does not change in quality or sellIn
    }
}
