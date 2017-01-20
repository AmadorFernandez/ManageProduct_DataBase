package com.jsw.MngProductDatabase.database;


import android.provider.BaseColumns;

import com.jsw.MngProductDatabase.Model.Category;
import com.jsw.MngProductDatabase.Model.Pharmacy;

/**
 * Clase que guarda el esquema de la clase de la base de datos de la app
 *
 */

public class ManageProductContract  {

    public static class CategoryEntry implements BaseColumns{

        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME = "ca_name";
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s " +
                "INTEGER PRIMARY KEY AUTOINCREMENT," + "%s TEXT NOT NULL)", TABLE_NAME,
                BaseColumns._ID, COLUMN_NAME);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",
                TABLE_NAME);

    }

    public static class ProductEntry implements BaseColumns{

        public static final String TABLE_NAME = "product";
        public static final String COLUMN_NAME = "pr_name";
        public static final String COLUMN_DESCRIPTION = "pr_description";
        public static final String COLUMN_BRAND = "pr_brand";
        public static final String COLUMN_DOSAGE = "pr_dosage";
        public static final String COLUMN_PRICE = "pr_price";
        public static final String COLUMN_STOCK = "pr_stock";
        public static final String COLUMN_IMAGE = "pr_image";
        public static final String COLUMN_CATEGORY = "pr_category";
        public static final String REFERENCE_ID_CATEGORY = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON" +
                " DELETE RESTRICT",  CategoryEntry.TABLE_NAME, CategoryEntry._ID);
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s " +
                        "INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT NOT NULL,%s TEXT NOT NULL,%s REAL," +
                "%s INTEGER,%s TEXT NOT NULL,%s TEXT NOT NULL" + ",%s TEXT NOT NULL," +
                "%s TEXT NOT NULL)", TABLE_NAME,
                BaseColumns._ID, COLUMN_NAME, COLUMN_DESCRIPTION,COLUMN_BRAND,
                COLUMN_DOSAGE, COLUMN_PRICE, COLUMN_STOCK, COLUMN_IMAGE, COLUMN_CATEGORY, REFERENCE_ID_CATEGORY);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",
                TABLE_NAME);

    }

    public static class PharmacyEntry implements BaseColumns{

        public static final String TABLE_NAME = "pharmacy";
        public static final String COLUMN_CIF = "ph_cif";
        public static final String COLUMN_ADDRESS = "ph_address";
        public static final String COLUMN_PHONE = "ph_phone";
        public static final String COLUMN_MAIL = "pr_mail";
        public static final String REFERENCE_ID_CATEGORY = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON" +
                " DELETE RESTRICT",  CategoryEntry.TABLE_NAME, CategoryEntry._ID);
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL, %s TEXT NOT NULL, % TEXT NOT NULL) %",
                _ID, COLUMN_CIF, COLUMN_ADDRESS, COLUMN_PHONE, COLUMN_MAIL, REFERENCE_ID_CATEGORY);
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",
                TABLE_NAME);

    }

    public static class StatusEntry implements BaseColumns{

        public static final String TABLE_NAME = "status";
        public static final String COLUMN_NAME = "st_name";
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s " +
                        "INTEGER PRIMARY KEY AUTOINCREMENT," + "%s TEXT NOT NULL)", TABLE_NAME,
                BaseColumns._ID, COLUMN_NAME);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",
                TABLE_NAME);

    }

    public static class InvoiceEntry implements BaseColumns{

        public static final String TABLE_NAME = "invoice";
        public static final String COLUMN_IN_PHARMACY = "in_pharmacy";
        public static final String COLUMN_DATE = "in_date";
        public static final String COLUMN_STATUS = "in_status";
        public static final String REFERENCE_ID_PHARMACY = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON" +
                " DELETE RESTRICT",  PharmacyEntry.TABLE_NAME, PharmacyEntry._ID);
        public static final String REFERENCE_ID_STATUS = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON" +
                " DELETE RESTRICT",  StatusEntry.TABLE_NAME, StatusEntry._ID);
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s INTEGER NOT NULL, %s TEXT, % INTENGER)");
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",
                TABLE_NAME);

    }

    public static class InvoiceLineEntry implements BaseColumns{

        public static final String TABLE_NAME = "invoice_line";
        public static final String COLUMN_IL_INVOICE = "il_invoice";
        public static final String COLUMN_IL_ORDER_PRODÇUCT = "il_order_product";
        public static final String COLUMN_IL_PRODUCT = "il_product";
        public static final String COLUMN_IL_AMOUNT = "il_amount";
        public static final String COLUMN_IL_PRICE = "il_price";
        public static final String REFERENCE_ID_PHARMACY = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON" +
                " DELETE RESTRICT",  PharmacyEntry.TABLE_NAME, PharmacyEntry._ID);
        public static final String REFERENCE_ID_STATUS = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON" +
                " DELETE RESTRICT",  StatusEntry.TABLE_NAME, StatusEntry._ID);
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "INTEGER NOT NULL, %s INTEGER NOT NULL, %s % INTEGER NOT NULL, % REAL NOT NULL )");
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",
                TABLE_NAME);

    }




}
