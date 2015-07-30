package kz.e16traning.coffeevan;

import kz.e16traning.coffeevan.goods.coffee.Coffee;
import kz.e16traning.coffeevan.properties.PropertiesOfProject;
import kz.e16traning.coffeevan.storage.Van;
import kz.e16traning.coffeevan.storage.action.Finder;
import kz.e16traning.coffeevan.storage.action.Loader;
import kz.e16traning.coffeevan.storage.action.Sorter;

/**
 * Точка входа
 */
public class Run {
    public static void main(String[] args) {
        PropertiesOfProject prop = new
                PropertiesOfProject(args, "price.txt").init();
        Van van = new Van(prop.getVolumeOfVan());
        Loader loader = new Loader("random",
                van, prop.getCostOfVan(), Coffee.class.getClass()).load();
        System.out.println(van);
        System.out.println("Total volume: " + van.getTotalVolume()
                + " / Used volume: " + van.getUsedVolume());
        System.out.println("Total money: " + loader.getTotalMoney()
                + " / Used money: " + loader.getUsedMoney());
        System.out.println("\nafter sort by "
                + prop.getTypeOfSort() + ": ");
        Sorter sorter = new Sorter(prop.getTypeOfSort(), van);
        sorter.sort();
        System.out.println(van);
        System.out.println("\nfound by " + prop.getTypeOfFind()
                + ": [" + prop.getStartOfFind() + " - "
                + prop.getEndOfFind() + "]");
        Finder finder = new Finder(van, prop.getTypeOfFind(),
                prop.getStartOfFind(), prop.getEndOfFind());
        System.out.println(finder.found());

    }
}
