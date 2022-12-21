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
import com.example.customsregulationsrroject.Counrty.RulePage;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class AdapterRulePage extends BaseAdapter {
    private Context mContext;
    List<RulePage> rulePageList;

   public AdapterRulePage(Context mContext, List<RulePage> ruleList) {
        this.mContext = mContext;
        this.rulePageList = ruleList;
    }

    @Override
    public int getCount() {
        return rulePageList.size();
    }

    @Override
    public Object getItem(int position) {
        return rulePageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rulePageList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.activity_country_rules_page,null); //Создание метода View

        TextView Country = view.findViewById(R.id.txtCountryName_RulesPage); //нахождение textView куда будет положено название страны

        TextView Enter_rules = view.findViewById(R.id.txtCountryEnterRules2); //нахождение textView куда будет положено правило въезда
        TextView Enter_rules1 = view.findViewById(R.id.txtCountryEnterRules3);
        TextView Enter_rules2 = view.findViewById(R.id.txtCountryEnterRules4);


        TextView ForbidenEnter_rules = view.findViewById(R.id.txtCountryForbiddenEnterRules2); //нахождение textView куда будет положено правило запрета въезда
        ImageView imageView = view.findViewById(R.id.imageView_RulesPage); //нахождение imageView куда будет положено изображение флага

        RulePage rulePage = rulePageList.get(position);//получение объекта страны

        Country.setText(rulePage.getCountry()); //присваиваем textView наименование страны текущего объекта

        Enter_rules.setText(rulePage.getEnter_rules());
        Enter_rules1.setText(rulePage.getEnter_rules1());

        ForbidenEnter_rules.setText(rulePage.getForbiddenEnter_rules());
        if(rulePage.getImage()!=null && !rulePage.getImage().equals("null"))
            imageView.setImageBitmap(getUserImage(rulePage.getImage())); //присваиваем imageView изображения страны текущего объекта

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

            return BitmapFactory.decodeResource(AdapterRulePage.this.mContext.getResources(),R.drawable.noimg);
        }
        else
        {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }

    }
}
