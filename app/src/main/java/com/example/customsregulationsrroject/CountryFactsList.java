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

import com.example.customsregulationsrroject.Counrty.FactModels;
import com.example.customsregulationsrroject.adapter.AdapterFactModels;
import com.example.customsregulationsrroject.network.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryFactsList extends AppCompatActivity {

    Connection connection;
    List<FactModels> data;
    ListView listView;
    AdapterFactModels pAdapter;
    EditText inputSearchFacts;
    String NameCountryFact = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_facts_list);

        GetDataFromSql();
        inputSearchFacts = findViewById(R.id.inputSearchFacts);

        inputSearchFacts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                NameCountryFact = " WHERE Country LIKE '%" + inputSearchFacts.getText().toString() + "%'";
                GetDataFromSql();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CountryFactsList.this, CountryFactPage.class);
                intent.putExtra("id", i);
                startActivity(intent);
                //listView.getSelectedItem().;
            }
        });
    }

    public void GetDataFromSql() {
        data = new ArrayList<FactModels>();
        listView = findViewById(R.id.lvDataCountriesFacts);
        pAdapter = new AdapterFactModels(CountryFactsList.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "SELECT id_country_fact,Country,Image FROM Countries_Facts" + NameCountryFact;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    FactModels tempMovie = new FactModels
                            (   resultSet.getInt("id_country_fact"),
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