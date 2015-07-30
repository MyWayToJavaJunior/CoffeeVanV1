package kz.e16traning.coffeevan.goods;

/**
 * Типизирующий интерфейс для товаров
 */
public interface IGoods {
    int getGoodsVolume();
    int getGoodsVolumeWOWrap();
    double getGoodsCost();
    String getGoodsCondition();
    String getGoodsType();
    String getGoodsWrap();
}
