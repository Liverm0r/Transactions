package com.liverm0r.transactions.business.interactors;


import com.liverm0r.transactions.ui.detail_transactions.DetailTransModel;

import io.reactivex.Single;

/**
 * Interactor is business feature, method is useCase
 */
public interface IDetailTransInteractor {
    Single<DetailTransModel> getModel();
}
