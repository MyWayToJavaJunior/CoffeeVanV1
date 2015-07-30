package kz.e16traning.coffeevan.properties;

import kz.e16traning.coffeevan.exception.ArgsCheckException;
import kz.e16traning.coffeevan.exception.LoadPriceFromFileException;
import kz.e16traning.coffeevan.goods.coffee.type.CoffeeType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 *
 */
public class PropertiesOfProject {
    private final String[] args;
    private final String nameOfPropFile;

    private int volumeOfVan;
    private double costOfVan;
    private String typeOfSort;
    private String typeOfFind;
    private double startOfFind;
    private double endOfFind;
    private static Map<CoffeeType, Double> priceFromFile = new HashMap<>();

    private void check() throws ArgsCheckException {
        if (args.length < 6 ||
                !checkForEntry(args[2], new String[]{
                        "volume", "cost", "wrap", "type", "condition"}) ||
                !checkForEntry(args[3], new String[]{
                        "volume", "cost"}))  {
            throw new ArgsCheckException();
        }
        try {
            this.volumeOfVan = Integer.valueOf(args[0]);
            this.costOfVan = Double.valueOf(args[1]);
            this.typeOfSort = args[2];
            this.typeOfFind = args[3];
            this.startOfFind = Double.valueOf(args[4]);
            this.endOfFind = Double.valueOf(args[5]);
        } catch (NumberFormatException e) {
            throw new ArgsCheckException();
        }
    }

    private boolean checkForEntry(String arg, String[] args) {
        Set<String> setOfSorts = new HashSet<>(
                Arrays.asList(args));
        return setOfSorts.contains(arg);
    }

    private void loadFormFile() throws LoadPriceFromFileException {
            try {
                Properties properties = new Properties();
                FileInputStream fis = new FileInputStream(nameOfPropFile);
                properties.load(fis);
                priceFromFile.put(CoffeeType.ARABICA, Double.valueOf(properties.getProperty(CoffeeType.ARABICA.name())));
                priceFromFile.put(CoffeeType.ROBUSTA, Double.valueOf(properties.getProperty(CoffeeType.ROBUSTA.name())));
                priceFromFile.put(CoffeeType.LIBERICA, Double.valueOf(properties.getProperty(CoffeeType.LIBERICA.name())));
            } catch (IOException e) {
                throw new LoadPriceFromFileException();
            }
    }

    public static Map<CoffeeType, Double> getPriceFromFile() {
        return priceFromFile;
    }

    public PropertiesOfProject init() {
        try {
            check();
            loadFormFile();
        } catch (ArgsCheckException | LoadPriceFromFileException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return this;
    }

    public PropertiesOfProject(String[] args, String nameOfPropFile) {
        this.args = args;
        this.nameOfPropFile = nameOfPropFile;
    }

    public int getVolumeOfVan() {
        return volumeOfVan;
    }

    public double getCostOfVan() {
        return costOfVan;
    }

    public String getTypeOfSort() {
        return typeOfSort;
    }

    public String getTypeOfFind() {
        return typeOfFind;
    }

    public double getStartOfFind() {
        return startOfFind;
    }

    public double getEndOfFind() {
        return endOfFind;
    }
}
