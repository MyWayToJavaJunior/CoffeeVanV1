package kz.e16traning.coffeevan.storage.action;

import kz.e16traning.coffeevan.goods.IGoods;
import kz.e16traning.coffeevan.storage.IStorage;

import java.util.ArrayList;

/**
 * Поиск.
 *
 */
public class Finder {
    private final double startValue;
    private final double endValue;
    private final String findBy;
    private final ArrayList<IGoods> goods;
    private final ArrayList<IGoods> foundGoods = new ArrayList<>();

    private String foundGoods() {
        StringBuilder sb = new StringBuilder();
        for (IGoods goods : this.foundGoods) {
            sb.append("(").append(goods.toString()).append(")\n");
        }
        return sb.toString();
    }

    private void findByVolume() {
        for (IGoods goods : this.goods) {
            if (goods.getGoodsVolume() >= this.startValue
                    && goods.getGoodsVolume() <= this.endValue)
                foundGoods.add(goods);
        }
    }

    private void findByCost() {
        for (IGoods goods : this.goods) {
            if (goods.getGoodsCost() >= this.startValue
                    && goods.getGoodsCost() <= this.endValue)
                foundGoods.add(goods);
        }
    }

    public Finder(IStorage storage, String findBy,
                  double startValue, double endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.findBy = findBy;
        this.goods = storage.goods();
    }

    public String found() {
        if ("cost".equals(findBy)) {
            findByCost();
        } else {
            findByVolume();
        }
        return foundGoods();
    }

}
