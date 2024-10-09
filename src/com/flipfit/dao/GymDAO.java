package com.flipfit.dao;
import com.flipfit.bean.GymCenter;

import java.util.ArrayList;

public class GymDAO {
    private static final ArrayList<GymCenter> gyms = new ArrayList<GymCenter>();

    public static void add(GymCenter gym) {
        gyms.add(gym);
        System.out.println("Gym data successfully added");
    }

    public static ArrayList<GymCenter> getGyms() {
        return gyms;
    }
}
