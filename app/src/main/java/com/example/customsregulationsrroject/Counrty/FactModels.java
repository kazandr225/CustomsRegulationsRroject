package com.example.customsregulationsrroject.Counrty;

import android.os.Parcel;
import android.os.Parcelable;

public class FactModels implements Parcelable{
    int id_country_fact;
    String Country;
    String Image;

    public FactModels(int id_country_fact, String country, String image)
    {
        this.id_country_fact = id_country_fact;
        Country = country;
        Image = image;
    }

    public int getID() {
        return id_country_fact;
    }

    public void setID(int id_country_fact) {
        this.id_country_fact = id_country_fact;
    }

    public String getCountry() {
        return Country;
    }
    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
    public void setCountry(String country) {
        Country = country;
    }

    protected FactModels(Parcel in) {
    }

    public static final Parcelable.Creator<FactModels> CREATOR = new Parcelable.Creator<FactModels>() {
        @Override
        public FactModels createFromParcel(Parcel in) {
            return new FactModels(in);
        }

        @Override
        public FactModels[] newArray(int size) {return new FactModels[size];}
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
