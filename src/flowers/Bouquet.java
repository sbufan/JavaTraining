package flowers;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Plant> plants;
    private int price;

    public Bouquet() {
        this.plants = new ArrayList<>();
        price = 0;
    }

    public Bouquet(List<Plant> plants) {
        this.plants = plants;
        for (Plant plant : plants) {
            price += plant.getPrice();
        }
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public int getPrice() {
        return price;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
        price += plant.getPrice();
    }

    public void addPlants(List<Plant> plants) {
        plants.addAll(plants);
        for (Plant plant : plants) {
            price += plant.getPrice();
        }
    }

    public Flower getLongestFlower() {
        int longestLength = 0;
        Plant longestFlower = null;
        for (Plant plant : plants) {
            if (plant.getLength() > longestLength) {
                longestFlower = plant;
                longestLength = plant.getLength();
            }
        }
        if (longestLength == 0) {
//            throw new RuntimeException("There is no flowers in bouquet");
            return new Flower("There is no flowers in bouquet", 0, "", 0, 0);
        } else {
            return (Flower) longestFlower;
        }
    }

    public Flower getFreshestFlower() {
        Integer freshness = null;
        Plant freshestFlower = null;
        for (Plant plant : plants) {
            Integer currentFreshness = plant.getFreshness();
            if (currentFreshness != null && (freshness == null || currentFreshness < freshness)) {
                freshestFlower = plant;
                freshness = currentFreshness;
            }
        }
        if (freshness == null) {
//            throw new RuntimeException("There is no flowers in bouquet");
            return new Flower("There is no flowers in bouquet", 0, "", 0, 0);
        } else {
            return (Flower) freshestFlower;
        }
    }
}
