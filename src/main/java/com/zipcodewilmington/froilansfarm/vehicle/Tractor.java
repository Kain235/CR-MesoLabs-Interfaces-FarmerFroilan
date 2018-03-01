package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.crop.CropRow;
import com.zipcodewilmington.froilansfarm.crop.Field;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;
import com.zipcodewilmington.froilansfarm.interfaces.FarmVehicle;

import java.util.ArrayList;

public class Tractor extends Vehicle implements FarmVehicle {

    private boolean hasRider = false;
    private ArrayList<Edible> tractorCropStorage = new ArrayList<Edible>();

    public void operate() {
        if (hasRider) {
            for (CropRow cropRow : Field.getCropRowsInField()) {
                for (Crop crop : cropRow.getCropsInRow()) {
                        tractorCropStorage.add(crop.yield());
                }
            }
        }
    }

    public String makeNoise() {
        return "Vrrrrrr";
    }

    public void ride() {
        this.hasRider = true;
    }

    public void stopRiding(){
        this.hasRider = false;
    }
}