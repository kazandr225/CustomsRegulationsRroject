package com.example.customsregulationsrroject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.customsregulationsrroject.Counrty.FactPage;
import com.example.customsregulationsrroject.adapter.AdapterFactPage;
import com.example.customsregulationsrroject.network.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryFactPage extends AppCompatActivity {

    Connection connection;
    List<FactPage> data;
    ListView listView;
    AdapterFactPage pAdapter;
    int id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_fact_page);

        Bundle arguments = getIntent().getExtras();
        id = arguments.getInt("id");
        //id += 1;

        TextView Country = findViewById(R.id.txtCountryName_FactPage);
        ImageView Image = findViewById(R.id.imageView_FactPage);
        TextView Text = findViewById(R.id.txtFactText_FactPage);

        GetDataFromSql();
        AdapterFactPage adapterFactPage = new AdapterFactPage(CountryFactPage.this, data);

        Country.setText(data.get(id).getCountry());
        Image.setImageBitmap(adapterFactPage.getUserImage(data.get(id).getImage()));
        Text.setText(data.get(id).getText());
    }

    public void GetDataFromSql() {
        data = new ArrayList<FactPage>();
        pAdapter = new AdapterFactPage(CountryFactPage.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "SELECT id_country_fact, Country, Image, Text FROM Countries_Facts ";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    FactPage tempMovie = new FactPage
                            (
                                    resultSet.getInt("id_country_fact"),
                                    resultSet.getString("Country"),
                                    resultSet.getString("Image"),
                                    resultSet.getString("Text")
                            );

                    data.add(tempMovie);
                }
                connection.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //pAdapter.notifyDataSetInvalidated();
        //listView.setAdapter(pAdapter);
    }
}