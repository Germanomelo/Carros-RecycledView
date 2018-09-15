package com.germanomelo.carros.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.germanomelo.carros.R;
import com.germanomelo.carros.listener.OnClickInteractionListener;
import com.germanomelo.carros.model.Car;
import com.germanomelo.carros.viewholder.CarViewHolder;

import java.util.List;

/**
 * Classe Adapter que extende a classe RecyclerView.Adapter
 * Necessária para implementação da RecyclerView
 */
public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {
    // Lista de carros
    private List<Car> mListCars;

    // Interface que define as ações
    private OnClickInteractionListener mOnClickInteractionListener;

    /**
     * Construtor
     */
    public CarListAdapter(List<Car> mListCars, OnClickInteractionListener listener) {
        this.mListCars = mListCars;
        this.mOnClickInteractionListener = listener;
    }

    /**
     * Responsável pela criação de linha
     */
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View carView = inflater.inflate(R.layout.row_car_list, parent, false);
        return new CarViewHolder(carView);
    }

    /**
     * Responsável por atribuir valores após linha criada
     */
    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = this.mListCars.get(position);
        holder.bindData(car, this.mOnClickInteractionListener);

    }

    /**
     * Retorna a guantidade de elementos do List
     */
    @Override
    public int getItemCount() {
        return this.mListCars.size();
    }
}
