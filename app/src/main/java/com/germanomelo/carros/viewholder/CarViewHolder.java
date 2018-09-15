package com.germanomelo.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.germanomelo.carros.R;
import com.germanomelo.carros.listener.OnClickInteractionListener;
import com.germanomelo.carros.model.Car;

/**
 * Responsável por fazer as manipulações de elementos de interface
 */
public class CarViewHolder extends RecyclerView.ViewHolder {

    // Elemento de interface
    private ImageView mImgCarPicture;
    private TextView mTextCarModel;
    private TextView mTextViewDetails;

    /**
     * Construtor
     */
    public CarViewHolder(View itemView) {
        super(itemView);
        this.mImgCarPicture = itemView.findViewById(R.id.img_car_pic);
        this.mTextCarModel = itemView.findViewById(R.id.text_car_model);
        this.mTextViewDetails = itemView.findViewById(R.id.text_car_details);
    }

    /**
     * Atribui valores aos elementos
     */
    public  void bindData(final Car car, final OnClickInteractionListener listener){
        // Alterar valores
        this.mImgCarPicture.setImageDrawable(car.getPicture());
        this.mTextCarModel.setText(car.getModel());

        // Evento de click
        this.mTextViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(car.getId());
            }
        });
    }
}
