package kz.e16traning.coffeevan.goods.coffee;

import kz.e16traning.coffeevan.goods.IGoods;
import kz.e16traning.coffeevan.goods.coffee.condition.CoffeeCondition;
import kz.e16traning.coffeevan.goods.coffee.type.CoffeeType;
import kz.e16traning.coffeevan.goods.coffee.wrap.CoffeeWrap;
import kz.e16traning.coffeevan.goods.price.PriceOfCoffee;

/**
 * Описание кофе.
 *
 */
public class Coffee implements IGoods {
    private final int volumeOfCoffee;
    private final double costOfCoffee;
    private final CoffeeType coffeeType;
    private final CoffeeWrap coffeeWrap;
    private final CoffeeCondition coffeeCondition;

    public Coffee(CoffeeType coffeeType, CoffeeWrap coffeeWrap, CoffeeCondition coffeeCondition) {
        PriceOfCoffee priceOfCoffee = new PriceOfCoffee();
        this.coffeeType = coffeeType;
        this.coffeeWrap = coffeeWrap;
        this.coffeeCondition = coffeeCondition;
        this.volumeOfCoffee = coffeeWrap.getVolume();
        this.costOfCoffee = priceOfCoffee.getPrice().get(coffeeType) * coffeeWrap.getVolume();
    }

    @Override
    public int getGoodsVolume() {
        return this.volumeOfCoffee + this.coffeeWrap.getVolumeOfWrap();
    }

    @Override
    public int getGoodsVolumeWOWrap() {
        return this.volumeOfCoffee;
    }

    @Override
    public double getGoodsCost() {
        return this.costOfCoffee;
    }

    @Override
    public String getGoodsCondition() {
        return this.coffeeCondition.name();
    }

    @Override
    public String getGoodsType() {
        return this.coffeeType.name();
    }

    @Override
    public String getGoodsWrap() {
        return this.coffeeWrap.name();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        return sb.append(this.coffeeType.name()).append(" : ")
                .append(this.coffeeCondition.name()).append(" : ")
                .append(this.coffeeWrap.name()).append(" : ")
                .append(this.costOfCoffee).append(" : ")
                .append(getGoodsVolume()).append(" : ")
                .append(getGoodsVolumeWOWrap()).append(")").toString();
    }

}
