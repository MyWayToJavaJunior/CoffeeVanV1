package kz.e16traning.coffeevan.goods.price;

import kz.e16traning.coffeevan.goods.coffee.type.CoffeeType;
import kz.e16traning.coffeevan.properties.PropertiesOfProject;

import java.util.HashMap;
import java.util.Map;

/**
 * Цены на грамм кофе.
 *
 */
public class PriceOfCoffee {
    private final Map<CoffeeType, Double> priceOfCoffee;

    public PriceOfCoffee() {
        priceOfCoffee = new HashMap<>();
        priceOfCoffee.putAll(PropertiesOfProject.getPriceFromFile());
    }

    public Map<CoffeeType, Double> getPrice() {
        return this.priceOfCoffee;
    }

}
