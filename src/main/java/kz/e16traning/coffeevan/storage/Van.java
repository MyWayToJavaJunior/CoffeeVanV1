package kz.e16traning.coffeevan.storage;

import kz.e16traning.coffeevan.goods.IGoods;

import java.util.ArrayList;

/**
 * Описание фургона
 */
public class Van implements IStorage{
    private final int totalVolume;
    private ArrayList<IGoods> goods;
    private int usedVolume;

    public Van(int totalVolume) {
        this.goods = new ArrayList<>();
        this.totalVolume = totalVolume;
    }

    @Override
    public int getTotalVolume() {
        return totalVolume;
    }

    @Override
    public void add(IGoods goods) {
        this.goods.add(goods);
        this.usedVolume += goods.getGoodsVolume();
    }

    @Override
    public ArrayList<IGoods> goods() {
        return goods;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (IGoods goods : this.goods) {
            sb.append("(").append(goods.toString()).append(")\n");
        }
        return sb.toString();
    }

    public int getUsedVolume() {
        return usedVolume;
    }

    @Override
    public int getFreeVolume() {
        return this.totalVolume - this.getUsedVolume();
    }
}
