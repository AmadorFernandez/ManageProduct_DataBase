package com.afg.MngProductDatabase.Presenter;

/*
 * Copyright (c) 2017 José Luis del Pino Gallardo.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  jose.gallardo994@gmail.com
 */

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import com.afg.MngProductDatabase.cursor.InvoiceCursorLoader;
import com.afg.MngProductDatabase.interfaces.IInvoicePresenter;

/**
 * Created by amador on 4/02/17.
 */

public class InvoicePresenter implements IInvoicePresenter, LoaderManager.LoaderCallbacks<Cursor> {

    public static final int INVOICE = 3;
    private IInvoicePresenter.View view;


    public InvoicePresenter(IInvoicePresenter.View view){

        this.view = view;
    }

    @Override
    public void getAllInvoices() {

        ((Activity)view.getContext()).getLoaderManager().initLoader(INVOICE, null, this);
    }

    public void reloadInvoices(){

        ((Activity)view.getContext()).getLoaderManager().restartLoader(INVOICE, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        return new InvoiceCursorLoader(view.getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        view.setCursorCategory(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        view.setCursorCategory(null);
    }
}
