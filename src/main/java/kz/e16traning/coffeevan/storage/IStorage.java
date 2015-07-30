package kz.e16traning.coffeevan.storage;

import kz.e16traning.coffeevan.goods.IGoods;

import java.util.ArrayList;

/**
 * Типизирующий интерфейс
 * для хранилищ.
 *
 */
public interface IStorage {
    int getTotalVolume();
    int getUsedVolume();
    int getFreeVolume();
    void add(IGoods goods);
    ArrayList<IGoods> goods();
}
