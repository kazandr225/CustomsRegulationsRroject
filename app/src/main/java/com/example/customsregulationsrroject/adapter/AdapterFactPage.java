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
import com.example.customsregulationsrroject.Counrty.FactPage;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class AdapterFactPage  extends BaseAdapter {

    private Context mContext;
    List<FactPage> factPageList;

    public AdapterFactPage(Context mContext, List<FactPage> factList) {
        this.mContext = mContext;
        this.factPageList = factList;
    }

    @Override
    public int getCount() {
        return factPageList.size();
    }

    @Override
    public Object getItem(int position) {
        return factPageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return factPageList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.activity_country_fact_page,null); //Создание метода View

        TextView Country = view.findViewById(R.id.txtCountryName_FactPage); //нахождение textView куда будет положено название страны
        TextView Text = view.findViewById(R.id.txtFactText_FactPage);

        ImageView imageView = view.findViewById(R.id.imageView_FactPage); //нахождение imageView куда будет положено изображение флага
        FactPage factPage = factPageList.get(position);//получение объекта страны
        Country.setText(factPage.getCountry()); //присваиваем textView наименование страны текущего объекта
        Text.setText(factPage.getText());
        if(factPage.getImage()!=null && !factPage.getImage().equals("null"))
            imageView.setImageBitmap(getUserImage(factPage.getImage())); //присваиваем imageView изображения страны текущего объекта

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

        if (encodedImg == null || encodedImg.equals("null"))
        {

            return BitmapFactory.decodeResource(AdapterFactPage.this.mContext.getResources(),R.drawable.noimg);
        }
        else
        {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }

    }

}
