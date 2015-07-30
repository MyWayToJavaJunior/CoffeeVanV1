package kz.e16traning.coffeevan.storage.action;

import kz.e16traning.coffeevan.goods.IGoods;
import kz.e16traning.coffeevan.storage.IStorage;

import java.util.ArrayList;

/**
 * Сортировка.
 *
 */
public class Sorter {
    private final String sortBy;
    private ArrayList<IGoods> goods;

    private void sortByVolume() {
        for (int i = 0; i < goods.size() - 1; i++) {
            for (int j = 0; j < goods.size() - 1; j++) {
                if (goods.get(j).getGoodsVolume()
                        > goods.get(j + 1).getGoodsVolume())
                    swap(j, j + 1);
            }
        }
    }

    private void sortByCost() {
        for (int i = 0; i < goods.size() - 1; i++) {
            for (int j = 0; j < goods.size() - 1; j++) {
                if (goods.get(j).getGoodsCost()
                        > goods.get(j + 1).getGoodsCost())
                    swap(j, j + 1);
            }
        }
    }

    private void sortByWrap() {
        for (int i = 0; i < goods.size() - 1; i++) {
            for (int j = 0; j < goods.size() - 1; j++) {
                if (goods.get(j).getGoodsWrap()
                        .compareTo(goods.get(j + 1)
                                .getGoodsWrap()) >= 0)
                    swap(j, j + 1);
            }
        }
    }

    private void sortByCondition() {
        for (int i = 0; i < goods.size() - 1; i++) {
            for (int j = 0; j < goods.size() - 1; j++) {
                if (goods.get(j).getGoodsCondition()
                        .compareTo(goods.get(j + 1)
                                .getGoodsCondition()) >= 0)
                    swap(j, j + 1);
            }
        }
    }

    private void sortByType() {
        for (int i = 0; i < goods.size() - 1; i++) {
            for (int j = 0; j < goods.size() - 1; j++) {
                if (goods.get(j).getGoodsType()
                        .compareTo(goods.get(j + 1)
                                .getGoodsType()) >= 0)
                    swap(j, j + 1);
            }
        }
    }

    private void swap(int j, int i) {
        IGoods swap = goods.get(j);
        goods.set(j, goods.get(i));
        goods.set(i, swap);
    }

    public Sorter(String sortBy, IStorage storage) {
        this.sortBy = sortBy;
        this.goods = storage.goods();
    }

    public void sort() {
        if ("type".equals(sortBy.toLowerCase())) sortByType();
        else if ("condition".equals(sortBy.toLowerCase())) sortByCondition();
        else if ("wrap".equals(sortBy.toLowerCase())) sortByWrap();
        else if ("cost".equals(sortBy.toLowerCase())) sortByCost();
        else if ("volume".equals(sortBy.toLowerCase())) sortByVolume();
    }



}
