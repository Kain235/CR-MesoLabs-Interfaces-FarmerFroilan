package com.zipcodewilmington.froilansfarm.person;

import com.zipcodewilmington.froilansfarm.animal.Chicken;
import com.zipcodewilmington.froilansfarm.animal.Egg;
import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.crop.CropRow;
import com.zipcodewilmington.froilansfarm.farm.ChickenCoop;
import com.zipcodewilmington.froilansfarm.farm.Silo;
import com.zipcodewilmington.froilansfarm.interfaces.Botanist;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Rider;

import java.util.ArrayList;

public class Farmer extends Person implements Rider, Botanist{

    private String name = "Froilan";
    private ArrayList<Edible> foodEaten = new ArrayList<Edible>();
    private ArrayList<Edible> eggHarvest = new ArrayList<Edible>();

    public void plant(CropRow cropRow, Crop crop) {
        Class classOfCrop = crop.getClass();
        for (int i = 0; i < 25; i++){
            try {
                cropRow.getCropsInRow().add((Crop) classOfCrop.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void harvestEggs(ChickenCoop[] chickenCoops){
        for (ChickenCoop chickenCoop: chickenCoops) {
            for (Chicken chicken: chickenCoop.getChickensInCoop()) {
                eggHarvest.add(chicken.yield());
                chicken.setHasBeenHarvested(true);
            }
        }
    }

    public void depositEggs(Silo silo){
        silo.storeFood(eggHarvest);
    }

    public String makeNoise() {
        return "I am making noise!";
    }

    public void mount(Rideable rideable) {
        rideable.ride();
    }

    public void dismount(Rideable rideable) {
        rideable.stopRiding();
    }

    public void eat(Edible food) {
        foodEaten.add(food);
    }

    public ArrayList<Edible> getFoodEaten() {
        return foodEaten;
    }

    public ArrayList<Edible> getEggHarvest() {
        return eggHarvest;
    }
}
