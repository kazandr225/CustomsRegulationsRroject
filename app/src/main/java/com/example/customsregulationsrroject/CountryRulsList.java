package com.example.customsregulationsrroject;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customsregulationsrroject.Counrty.Models;
import com.example.customsregulationsrroject.adapter.AdapterModels;
import com.example.customsregulationsrroject.network.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryRulsList extends AppCompatActivity {

    Connection connection;
    List<Models> data;
    ListView listView;
    AdapterModels pAdapter;
    EditText inputSearchRules;
    String NameCountry = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_ruls_list);

        GetDataFromSql();

        inputSearchRules = findViewById(R.id.inputSearchRules);

        inputSearchRules.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                NameCountry = " WHERE Country LIKE '%" + inputSearchRules.getText().toString() + "%'";
                GetDataFromSql();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CountryRulsList.this, CountryRules_Page.class);
                intent.putExtra("id", i);
                startActivity(intent);
                //listView.getSelectedItem().;
            }
        });
    }


    public void GetDataFromSql() {
        data = new ArrayList<Models>();
        listView = findViewById(R.id.lvDataCountriesRules);
        pAdapter = new AdapterModels(CountryRulsList.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "SELECT id_country,Country,Image FROM Countries" + NameCountry;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Models tempMovie = new Models
                            (   resultSet.getInt("id_country"),
                                    resultSet.getString("Country"),
                                    resultSet.getString("Image")
                            );
                    data.add(tempMovie);
                }
                connection.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }

}