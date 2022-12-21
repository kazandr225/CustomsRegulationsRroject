package com.example.customsregulationsrroject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customsregulationsrroject.R;
import com.example.customsregulationsrroject.Counrty.FactModels;

import java.util.List;

public class AdapterFactModels extends BaseAdapter {

    private Context mContext;
    List<FactModels> factModelsList;

    public AdapterFactModels(Context mContext, List<FactModels> maskfactList) {
        this.mContext = mContext;
        this.factModelsList = maskfactList;
    }

    @Override
    public int getCount() {
        return factModelsList.size();
    }

    @Override
    public Object getItem(int position) {
        return factModelsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return factModelsList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.item_second_list, null); //Создание метода View

        TextView Country = view.findViewById(R.id.txtCountryName_Fact); //нахождение textView куда будет положено название страны
        ImageView imageView = view.findViewById(R.id.imageView_Fact); //нахождение imageView куда будет положено изображение флага
        FactModels factmodels = factModelsList.get(position);//получение объекта страны
        Country.setText(factmodels.getCountry()); //присваиваем textView наименование страны текущего объекта
        if (factmodels.getImage() != null && !factmodels.getImage().equals("null"))
            imageView.setImageBitmap(getUserImage(factmodels.getImage())); //присваиваем imageView изображения страны текущего объекта

        return view;
    }

    private Bitmap getUserImage(String encodedImg) //метод для рапарсивания строки в изображение
    {
        byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}