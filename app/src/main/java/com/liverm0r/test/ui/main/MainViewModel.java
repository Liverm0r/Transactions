package com.liverm0r.test.ui.main;

import android.support.annotation.NonNull;

import com.liverm0r.test.common.rx_utils.RxSchedulersAbs;
import com.liverm0r.test.dagger.main.MainScope;
import com.liverm0r.test.ui.common.error.IErrorHandler;
import com.liverm0r.test.ui.common.ui_base.BaseViewModelAbs;

import javax.inject.Inject;

@MainScope
class MainViewModel extends BaseViewModelAbs {
    private static final String TAG = MainViewModel.class.getSimpleName();

    private IMainRouter mRouter;

    @Inject MainViewModel(@NonNull RxSchedulersAbs rxSchedulers,
                          @NonNull IErrorHandler errorHandler,
                          @NonNull IMainRouter router) {
        super(rxSchedulers, errorHandler);
        mRouter = router;
    }

    //—————————————————————————————————————————————————————————————————————— INTERFACE

    void created() {
        mRouter.startTransactions();
    }
}
