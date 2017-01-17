package com.liverm0r.test.ui.detail_transactions;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liverm0r.test.R;
import com.liverm0r.test.data.model.DetailTransaction;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTransAdapter extends RecyclerView.Adapter<DetailTransAdapter.ViewHolder> {

    private List<DetailTransaction> mTransactions;

    public DetailTransAdapter() {
        mTransactions = new ArrayList<>();
    }

    public void setTransactionsModels(@NonNull List<DetailTransaction> transactions) {
        mTransactions = transactions;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_trans_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        DetailTransaction transaction = mTransactions.get(position);
        setText(holder.textCurrFrom, transaction.getFrom(), transaction.getSumFrom());
        setText(holder.textCurrTo, transaction.getTo(), transaction.getSumTo());
    }

    private void setText(TextView tv, String curr, float amount) {
        //String.format("Total: f %.2f", m.getTotal())
        //tv.setText(curr + ": " + String.valueOf(amount));
        tv.setText(String.format("%s: %.2f", curr, amount));

    }

    @Override public int getItemCount() {
        return mTransactions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.detailTransCurrFrom) TextView textCurrFrom;
        @BindView(R.id.detailTransCurrTo) TextView textCurrTo;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}