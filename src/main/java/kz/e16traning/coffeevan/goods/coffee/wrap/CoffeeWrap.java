package kz.e16traning.coffeevan.goods.coffee.wrap;

/**
 * Упаковка Стекло/Пластик.
 *
 */
public enum CoffeeWrap {
    GLASS (20, 5),
    PLASTIC (8, 2);

    private final int volume;
    private final int wrapVolume;

    CoffeeWrap(int volumeOfWrap, int wrapVolume) {
        this.volume = volumeOfWrap;
        this.wrapVolume = wrapVolume;
    }

    /**
     * Возвращает объем упаковки.
     *
     * @return обьем упаковки
     */
    public int getVolumeOfWrap() {
        return this.wrapVolume;
    }

    /**
     * Возвращает объем тары.
     *
     * @return обьем тары
     */
    public int getVolume() {
        return this.volume;
    }
}
