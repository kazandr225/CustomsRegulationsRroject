package com.example.customsregulationsrroject.Counrty;


import android.os.Parcel;
import android.os.Parcelable;


public class RulePage implements  Parcelable{
    int id_country;
    String Country;
    String Image;

    String Enter_rules;
    String Enter_rules1;
    String Enter_rules2;
    String Enter_rules3;
    String Enter_rules4;

    String ForbiddenEnter_rules;
    String ForbiddenEnter_rules1;
    String ForbiddenEnter_rules2;
    String ForbiddenEnter_rules3;
    String ForbiddenEnter_rules4;

    String Departure_rules;
    String Departure_rules1;
    String Departure_rules2;

    String ForbidenDeparture_rules;
    String ForbidenDeparture_rules1;
    String ForbidenDeparture_rules2;

    public RulePage(int id_country, String country, String image, String enterRules, String enterRules1, String enterRules2, String enterRules3, String enterRules4, String forbiddenEnterRules, String forbiddenEnterRules1, String forbiddenEnterRules2, String forbiddenEnterRules3, String forbiddenEnterRules4, String departure_rules, String departure_rules1, String departure_rules2, String forbidenDeparture_rules, String forbidenDeparture_rules1, String forbidenDeparture_rules2)
    {
        this.id_country = id_country;
        Country = country;
        Image = image;

        Enter_rules = enterRules;
        Enter_rules1 = enterRules1;
        Enter_rules2 = enterRules2;
        Enter_rules3 = enterRules3;
        Enter_rules4 = enterRules4;

        ForbiddenEnter_rules = forbiddenEnterRules;
        ForbiddenEnter_rules1 = forbiddenEnterRules1;
        ForbiddenEnter_rules2 = forbiddenEnterRules2;
        ForbiddenEnter_rules3 = forbiddenEnterRules3;
        ForbiddenEnter_rules4 = forbiddenEnterRules4;

        Departure_rules = departure_rules;
        Departure_rules1 = departure_rules1;
        Departure_rules2 = departure_rules2;

        ForbidenDeparture_rules = forbidenDeparture_rules;
        ForbidenDeparture_rules1 = forbidenDeparture_rules1;
        ForbidenDeparture_rules2 = forbidenDeparture_rules2;

    }

    public int getID() {
        return id_country;
    }
    public void setID(int id_country) {
        this.id_country = id_country;
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

    public String getEnter_rules() {
        return Enter_rules;
    }
    public String getForbiddenEnter_rules() {
        return ForbiddenEnter_rules;
    }

    public void setEnter_rules(String forbiddenEnter_rules) {
        Enter_rules = forbiddenEnter_rules;
    }
    public void setForbiddenEnter_rules(String forbiddenEnter_rules) {
        ForbiddenEnter_rules = forbiddenEnter_rules;
    }

    public String getEnter_rules1(){ return Enter_rules1;}
    public String getEnter_rules2(){ return Enter_rules2;}
    public String getEnter_rules3(){ return Enter_rules3;}
    public String getEnter_rules4(){ return Enter_rules4;}

    public void setEnter_rules1(String enter_rules1){ Enter_rules1 = enter_rules1;}
    public void setEnter_rules2(String enter_rules2){ Enter_rules2 = enter_rules2;}
    public void setEnter_rules3(String enter_rules3){ Enter_rules3 = enter_rules3;}
    public void setEnter_rules4(String enter_rules4){ Enter_rules4 = enter_rules4;}

    public String getForbiddenEnter_rules1() {
        return ForbiddenEnter_rules1;
    }
    public String getForbiddenEnter_rules2() {
        return ForbiddenEnter_rules2;
    }
    public String getForbiddenEnter_rules3() {
        return ForbiddenEnter_rules3;
    }
    public String getForbiddenEnter_rules4() {
        return ForbiddenEnter_rules4;
    }

    public void setForbiddenEnter_rules1(String forbiddenEnter_rules1){ ForbiddenEnter_rules1 = forbiddenEnter_rules1; }
    public void setForbiddenEnter_rules2(String forbiddenEnter_rules2){ ForbiddenEnter_rules2 = forbiddenEnter_rules2; }
    public void setForbiddenEnter_rules3(String forbiddenEnter_rules3){ ForbiddenEnter_rules3 = forbiddenEnter_rules3; }
    public void setForbiddenEnter_rules4(String forbiddenEnter_rules4){ ForbiddenEnter_rules4 = forbiddenEnter_rules4; }

    public String getDeparture_rules() { return  Departure_rules; }
    public String getDeparture_rules1() { return  Departure_rules1; }
    public String getDeparture_rules2() { return  Departure_rules2; }

    public void setDeparture_rules(String departure_rules) { Departure_rules = departure_rules; }
    public void setDeparture_rules1(String departure_rules1) { Departure_rules1 = departure_rules1; }
    public void setDeparture_rules2(String departure_rules2) { Departure_rules2 = departure_rules2; }

    public String getForbidenDeparture_rules() { return  ForbidenDeparture_rules; }
    public String getForbidenDeparture_rules1() { return  ForbidenDeparture_rules1; }
    public String getForbidenDeparture_rules2() { return  ForbidenDeparture_rules2; }

    public  void setForbidenDeparture_rules(String forbidenDeparture_rules) { ForbidenDeparture_rules = forbidenDeparture_rules; }
    public  void setForbidenDeparture_rules1(String forbidenDeparture_rules1) { ForbidenDeparture_rules1 = forbidenDeparture_rules1; }
    public  void setForbidenDeparture_rules2(String forbidenDeparture_rules2) { ForbidenDeparture_rules2 = forbidenDeparture_rules2; }



    protected RulePage(Parcel in) {
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
