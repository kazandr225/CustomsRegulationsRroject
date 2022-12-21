package com.example.customsregulationsrroject.Counrty;

import android.os.Parcel;
import android.os.Parcelable;

public class FactPage implements Parcelable{
    int id_country_fact;
    String Country;
    String Image;

    String Text;

    public FactPage(int id_country_fact, String country, String image, String text)
    {
        this.id_country_fact = id_country_fact;
        Country = country;
        Image = image;
        Text = text;
    }

    public int getID(){ return  id_country_fact; }
    public void setID(int id_country_fact) { this.id_country_fact = id_country_fact; }

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

    public  String getText () { return  Text; }
    public void setText (String text) { Text = text; }

    protected FactPage(Parcel in) {
    }

    public static final Parcelable.Creator<RulePage> CREATOR = new Parcelable.Creator<RulePage>() {
        @Override
        public RulePage createFromParcel(Parcel in) {
            return new RulePage(in);
        }

        @Override
        public RulePage[] newArray(int size) {
            return new RulePage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}


