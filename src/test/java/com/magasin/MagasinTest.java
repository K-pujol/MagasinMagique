package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void GoldenMaster() {

        Item[] items = new Item[]{new Item("commonDayTen", 10, 19), // le sellIn et qualité doivent décrémenter de 1 par jour jusqu'a sellIn 0, ensuite qualité décremente de 2
                new Item("Comté", 10, 40), //  qualité augmente de +1 chaque jour
                new Item("Kryptonite", 0, 80), // normalement ne bouge pas
                new Item("Pass VIP Concert", 13, 10), // quality +1 | si sellIn <= 10: quality +2 | si sellIn <=5: quality+3 | si sellIn=0 : quality =0
                new Item("Comté", 10, 20), // Comté2
                new Item ("commonInferior", -5, -5),
                new Item ("Pass VIP Concert", 4,49),
                new Item("Kryptonite", -1, 1),
        };
        Magasin app = new Magasin(items);

        for (int i = 0; i < 15; i++) { // boucle commun
            app.updateQuality();
            System.out.println("Comté | Jour restant péremption :" + app.items[4].sellIn + " Qualité :" + app.items[4].quality);
        }
       // System.out.println("Commun | Jour restant péremption :" + app.items[0].sellIn + " Qualité :" + app.items[0].quality);

        System.out.println();


       // System.out.println("Comté | Jour restant péremption :" + app.items[1].sellIn + " Qualité :" + app.items[1].quality);


        System.out.println();


      //  System.out.println("Kryptonite | Jour restant péremption :" + app.items[2].sellIn + " Qualité :" + app.items[2].quality);


        System.out.println();


       // System.out.println("Pass VIP Concert | Jour restant péremption :" + app.items[3].sellIn + " Qualité :" + app.items[3].quality);


    }


    @Test
    void checkIfSellinDecrease() {
        Item[] items = new Item[]{new Item("gradur", 8, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
    }

    @Test
    void checkIfQualityDecrease() {
        Item[] items = new Item[]{new Item("gradur", 8, 20)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }


}
