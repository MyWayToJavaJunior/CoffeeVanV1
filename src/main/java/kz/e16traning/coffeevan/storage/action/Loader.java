package kz.e16traning.coffeevan.storage.action;

import kz.e16traning.coffeevan.goods.IGoods;
import kz.e16traning.coffeevan.goods.coffee.Coffee;
import kz.e16traning.coffeevan.goods.coffee.condition.CoffeeCondition;
import kz.e16traning.coffeevan.goods.coffee.type.CoffeeType;
import kz.e16traning.coffeevan.goods.coffee.wrap.CoffeeWrap;
import kz.e16traning.coffeevan.storage.IStorage;

import java.util.Random;

/**
 * Загрузка
 */
public class Loader {
    private final String typeOfLoad;
    private final IStorage storage;
    private final double totalMoney;
    private double moneyOfLoad;
    private final Class typeOfGoods;

    private boolean addItem(IGoods goods) {
        if (isVolumeRemains(goods)
                && isMoneyRemains(goods)) {
            storage.add(goods);
            this.setMoneyRemains(goods.getGoodsCost());
            return true;
        }
        return false;
    }

    private boolean isVolumeRemains(IGoods goods) {
        return storage.getFreeVolume() > goods.getGoodsVolume();
    }

    private boolean isMoneyRemains(IGoods goods) {
        return this.moneyOfLoad > goods.getGoodsCost();
    }

    private void setMoneyRemains(double moneyRemains) {
        this.moneyOfLoad -= moneyRemains;
    }

    private static class RandomLoader {
        private static Random rand = new Random();
        private static IGoods getCoffee() {
            return new Coffee(CoffeeType.values()
                    [rand.nextInt(CoffeeType.values().length)],
                    CoffeeWrap.values()
                            [rand.nextInt(CoffeeWrap.values().length)],
                    CoffeeCondition.values()
                            [rand.nextInt(CoffeeCondition.values().length)]);
        }
    }

    public Loader(String typeOfLoad, IStorage storage,
                  double moneyOfLoad, Class typeOfGoods) {
        this.typeOfLoad = typeOfLoad;
        this.storage = storage;
        this.totalMoney = moneyOfLoad;
        this.moneyOfLoad = moneyOfLoad;
        this.typeOfGoods = typeOfGoods;
    }

    public Loader load() {
        if ("random".equals(this.typeOfLoad)
                && Coffee.class.getClass().equals(typeOfGoods)) {
            while (true) {
                IGoods goods = RandomLoader.getCoffee();
                if (!addItem(goods)) break;
            }
        }
        return this;
    }

    public double getTotalMoney() {
        return this.totalMoney;
    }

    public double getUsedMoney() {
        return this.totalMoney
                - this.moneyOfLoad;
    }
}
