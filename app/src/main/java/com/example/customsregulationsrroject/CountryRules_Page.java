package com.example.customsregulationsrroject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.customsregulationsrroject.Counrty.RulePage;
import com.example.customsregulationsrroject.adapter.AdapterRulePage;
import com.example.customsregulationsrroject.network.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryRules_Page extends AppCompatActivity {

    Connection connection;
    List<RulePage> data;
    ListView listView;
    AdapterRulePage pAdapter;
    int id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_rules_page);

        Bundle arguments = getIntent().getExtras();
        id = arguments.getInt("id");
        //id += 1;

        TextView Country = findViewById(R.id.txtCountryName_RulesPage);
        ImageView Image = findViewById(R.id.imageView_RulesPage);

        TextView Enter_rules = findViewById(R.id.txtCountryEnterRules2);
        TextView Enter_rules1 = findViewById(R.id.txtCountryEnterRules3);
        TextView Enter_rules2 = findViewById(R.id.txtCountryEnterRules4);
        TextView Enter_rules3 = findViewById(R.id.txtCountryEnterRules5);
        TextView Enter_rules4 = findViewById(R.id.txtCountryEnterRules6);

        TextView ForbidenEnter_rules = findViewById(R.id.txtCountryForbiddenEnterRules2);
        TextView ForbidenEnter_rules1 = findViewById(R.id.txtCountryForbiddenEnterRules3);
        TextView ForbidenEnter_rules2 = findViewById(R.id.txtCountryForbiddenEnterRules4);
        TextView ForbidenEnter_rules3 = findViewById(R.id.txtCountryForbiddenEnterRules5);
        TextView ForbidenEnter_rules4 = findViewById(R.id.txtCountryForbiddenEnterRules6);

        TextView Departure_rules = findViewById(R.id.txtCountryDeparture_rules2);
        TextView Departure_rules1 = findViewById(R.id.txtCountryDeparture_rules3);
        TextView Departure_rules2 = findViewById(R.id.txtCountryDeparture_rules4);

        TextView ForbidenDeparture_rules = findViewById(R.id.txtCoubtryForbidenDeparture_rules2);
        TextView ForbidenDeparture_rules1 = findViewById(R.id.txtCoubtryForbidenDeparture_rules3);
        TextView ForbidenDeparture_rules2 = findViewById(R.id.txtCoubtryForbidenDeparture_rules4);

        GetDataFromSql();
        AdapterRulePage adapterRulePage = new AdapterRulePage(CountryRules_Page.this, data);

        Country.setText(data.get(id).getCountry());
        Image.setImageBitmap(adapterRulePage.getUserImage(data.get(id).getImage()));

        Enter_rules.setText(data.get(id).getEnter_rules());
        Enter_rules1.setText(data.get(id).getEnter_rules1());
        Enter_rules2.setText(data.get(id).getEnter_rules2());
        Enter_rules3.setText(data.get(id).getEnter_rules3());
        Enter_rules4.setText(data.get(id).getEnter_rules4());

        ForbidenEnter_rules.setText(data.get(id).getForbiddenEnter_rules());
        ForbidenEnter_rules1.setText(data.get(id).getForbiddenEnter_rules1());
        ForbidenEnter_rules2.setText(data.get(id).getForbiddenEnter_rules2());
        ForbidenEnter_rules3.setText(data.get(id).getForbiddenEnter_rules3());
        ForbidenEnter_rules4.setText(data.get(id).getForbiddenEnter_rules4());

        Departure_rules.setText(data.get(id).getDeparture_rules());
        Departure_rules1.setText(data.get(id).getDeparture_rules1());
        Departure_rules2.setText(data.get(id).getDeparture_rules2());

        ForbidenDeparture_rules.setText(data.get(id).getForbidenDeparture_rules());
        ForbidenDeparture_rules1.setText(data.get(id).getForbidenDeparture_rules1());
        ForbidenDeparture_rules2.setText(data.get(id).getForbidenDeparture_rules2());
    }
    public void GetDataFromSql() {
        data = new ArrayList<RulePage>();
        pAdapter = new AdapterRulePage(CountryRules_Page.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "SELECT id_country,Country,Image, Enter_rules, Enter_rules1, Enter_rules2, Enter_rules3, Enter_rules4, ForbidenEnter_rules, ForbidenEnter_rules1, ForbidenEnter_rules2, ForbidenEnter_rules3, ForbidenEnter_rules4, Departure_rules, Departure_rules1, Departure_rules2, ForbidenDeparture_rules, ForbidenDeparture_rules1, ForbidenDeparture_rules2 FROM Countries ";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    RulePage tempMovie = new RulePage
                            (   resultSet.getInt("id_country"),
                                    resultSet.getString("Country"),
                                    resultSet.getString("Image"),
                                    resultSet.getString("Enter_rules"),
                                    resultSet.getString("Enter_rules1"),
                                    resultSet.getString("Enter_rules2"),
                                    resultSet.getString("Enter_rules3"),
                                    resultSet.getString("Enter_rules4"),
                                    resultSet.getString("ForbidenEnter_rules"),
                                    resultSet.getString("ForbidenEnter_rules1"),
                                    resultSet.getString("ForbidenEnter_rules2"),
                                    resultSet.getString("ForbidenEnter_rules3"),
                                    resultSet.getString("ForbidenEnter_rules4"),
                                    resultSet.getString("Departure_rules"),
                                    resultSet.getString("Departure_rules1"),
                                    resultSet.getString("Departure_rules2"),
                                    resultSet.getString("ForbidenDeparture_rules"),
                                    resultSet.getString("ForbidenDeparture_rules1"),
                                    resultSet.getString("ForbidenDeparture_rules2")
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