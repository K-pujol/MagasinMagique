package com.magasin;

import java.util.Objects;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            String name = item.name;
            if (Objects.equals(name, "Kryptonite")) continue;
            else if (item.quality < 0) {
            } else if (Objects.equals(name, "Comté") && item.sellIn > 0 || Objects.equals(name, "Pass VIP Concert") && item.sellIn > 10) {
                item.quality++;
            } else if (Objects.equals(name, "Comté") && item.sellIn <= 0 || Objects.equals(name, "Pass VIP Concert") && item.sellIn > 5) {
                item.quality = item.quality + 2;
            } else if (Objects.equals(name, "Pass VIP Concert") && item.sellIn > 0) {
                item.quality = item.quality + 3;
            } else if (Objects.equals(name, "Pass VIP Concert") && item.sellIn <= 0) {
                item.quality = 0;
            } else if (item.sellIn > 0 && item.quality > 0 || item.sellIn > 0 && item.quality == 1 || item.sellIn < 0 && item.quality < 2) {
                item.quality--;
            } else if (item.quality > 2) {
                item.quality = item.quality - 2;
            }
            item.sellIn--;
            if (item.sellIn < 0 && item.quality ==50) {
                item.quality=0;
            }  else if (item.quality > 50) {
                item.quality = 50;
            }
        }
    }
}
/*
            if (!items[i].name.equals("Comté") && !items[i].name.equals("Pass VIP Concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Kryptonite")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Kryptonite")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Comté")) {
                    if (!items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Kryptonite")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }*/


