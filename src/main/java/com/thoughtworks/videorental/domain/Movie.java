package com.thoughtworks.videorental.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Movie {
    private String title;
    private boolean isNewlyReleased;

    public Movie(String title, boolean isNewlyReleased) {
        this.title = title;
        this.isNewlyReleased = isNewlyReleased;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(final int daysRented) {
        if (isNewlyReleased()) {
            return newlyReleaseMoviePricing(daysRented);
        }
        return oldMoviePricing(daysRented);
    }

    private int oldMoviePricing(int daysRented) {
        return daysRented * 1;
    }

    private int newlyReleaseMoviePricing(int daysRented) {
        int basePrice = 3;
        return basePrice + extraDaysPrice(daysRented);
    }

    private int extraDaysPrice(int daysRented) {
        int extraDaysRented = daysRented - 2;
        int extraDayPrice = 2;

        if (extraDaysRented > 0) return extraDaysRented * extraDayPrice;
        else return 0;
    }

    public boolean isNewlyReleased() {
        return isNewlyReleased;
    }
}
