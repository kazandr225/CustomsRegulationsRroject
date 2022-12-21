package com.example.customsregulationsrroject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customsregulationsrroject.R;
import com.example.customsregulationsrroject.Counrty.Models;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class AdapterModels extends BaseAdapter {

    private Context mContext;
    List<Models> modelsList;

    public AdapterModels(Context mContext, List<Models> maskList) {
        this.mContext = mContext;
        this.modelsList = maskList;
    }

    @Override
    public int getCount() {
        return modelsList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return modelsList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.item_first_list,null); //Создание метода View

        TextView Country = view.findViewById(R.id.txtCountryName); //нахождение textView куда будет положено название страны
        ImageView imageView = view.findViewById(R.id.imageView); //нахождение imageView куда будет положено изображение флага
        Models models = modelsList.get(position);//получение объекта страны
        Country.setText(models.getCountry()); //присваиваем textView наименование страны текущего объекта
        if(models.getImage()!=null && !models.getImage().equals("null"))
            imageView.setImageBitmap(getUserImage(models.getImage())); //присваиваем imageView изображения страны текущего объекта

        return view;
    }
    public static String getStrImage(Bitmap encodeImg)
    {
        int w = 150;
        int h = encodeImg.getHeight() * w / encodeImg.getWidth();
        Bitmap b = Bitmap.createScaledBitmap(encodeImg, w, h,false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return java.util.Base64.getEncoder().encodeToString(bytes);

        }
        else
        {
            return "";
        }
    }
    public Bitmap getUserImage(String encodedImg) //метод для рапарсивания строки в изображение
    {
        byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
        if (bytes == null)
        {
            return BitmapFactory.decodeResource(AdapterModels.this.mContext.getResources(),R.drawable.noimg);
        }
        else
        {
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }

    }


}
