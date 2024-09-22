package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    private final Map<String, ItemStrategy> strategies = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        initializeStrategies();
    }

    private void initializeStrategies() {
        strategies.put(AGED_BRIE, new AgedBrieStrategy());
        strategies.put(BACKSTAGE_PASSES, new BackstagePassesStrategy());
        strategies.put(SULFURAS, new SulfurasStrategy());
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategy strategy = getStrategy(item);
            strategy.update(item);
        }
    }

    private ItemStrategy getStrategy(Item item) {
        if (strategies.containsKey(item.name)) {
            return strategies.get(item.name);
        }

        return new NormalItemStrategy();
    }
}
