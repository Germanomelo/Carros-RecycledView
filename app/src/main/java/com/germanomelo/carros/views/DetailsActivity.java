package com.germanomelo.carros.views;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.germanomelo.carros.R;
import com.germanomelo.carros.constants.CarrosConstants;
import com.germanomelo.carros.controller.CarMock;
import com.germanomelo.carros.model.Car;

public class DetailsActivity extends AppCompatActivity {

    // Variáveis da classe
    private ViewHolder mViewHolder;
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        initVars();
        getDataFromActivity();
        setData();
    }

    /**
     * Inicializa variaveis da classe
     */
    private void initVars() {
        this.mViewHolder = new ViewHolder();
        this.mCarMock = new CarMock(this);
    }

    /**
     * Obtem valores passados por paramentro
     */
    public void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if(extras!= null){
           this.mCar = this.mCarMock.getCar(extras.getInt(CarrosConstants.CARRO_ID));
        }
    }

    /**
     * atribui valores aos elemento de interface
     */
    private void setData() {
        this.mViewHolder.imgCarPicture.setImageDrawable(this.mCar.getPicture());
        this.mViewHolder.textModel.setText(this.mCar.getModel());
        this.mViewHolder.textManuFacturer.setText(this.mCar.getManufacturer());
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.getHorsePower()));
        this.mViewHolder.textPrice.setText("R$ "+String.valueOf(this.mCar.getPrice()));

    }

    /**
     * ViewHolder
     */
    private class ViewHolder{
        ImageView imgCarPicture;
        TextView textModel;
        TextView textManuFacturer;
        TextView textHorsePower;
        TextView textPrice;

        /**
         * Instancia elemenots da ViewHolder
         */
        public ViewHolder(){
            this.imgCarPicture = findViewById(R.id.img_car_pic_details);
            this.textModel = findViewById(R.id.text_car_model_details);
            this.textManuFacturer = findViewById(R.id.text_manufacturer_details);
            this.textHorsePower = findViewById(R.id.text_horse_power_details);
            this.textPrice = findViewById(R.id.text_price_details);
        }
    }
}
