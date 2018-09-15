package com.germanomelo.carros.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.germanomelo.carros.R;
import com.germanomelo.carros.adapter.CarListAdapter;
import com.germanomelo.carros.constants.CarrosConstants;
import com.germanomelo.carros.controller.CarMock;
import com.germanomelo.carros.listener.OnClickInteractionListener;

public class MainActivity extends AppCompatActivity {

    // Variáveis da classe
    ViewHolder mViewHolder;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Instancia variáveis
        mViewHolder = new ViewHolder();

        initComponents();
    }

    /**
     * Iniciar componentes
     */
    private void initComponents(){
        this.mContext = this;

        CarMock carMock = new CarMock(this);

        OnClickInteractionListener listener = new OnClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID, id);
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        // Definir Adapter
        CarListAdapter carListAdapter = new CarListAdapter(carMock.getmListCar(), listener);
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        // Definir Layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);
    }

    /**
     * Classe ViewHolder
     */
    private class ViewHolder{
        RecyclerView recyclerCars;

        private ViewHolder(){
            recyclerCars = findViewById(R.id.recycler_cars);
        }
    }
}
