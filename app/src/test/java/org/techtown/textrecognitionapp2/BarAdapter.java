package org.techtown.textrecognitionapp2;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class BarAdapter {
    private Context mContext;
    private SQLiteDatabase mDb;
    private BarDBActivityHelper mDbHelper;

    public BarAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new BarDBActivityHelper(mContext);
    }

    public BarAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public BarAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public Cursor selectBar(String[] colums, //category select
                            String selection,
                            String[] selectionArgs,
                            String groupBy,
                            String having,
                            String orderby)
    { //select 인자에 맞춘 질의문입니다. 조건에 맞춰 null을 사용하면 됩니다.
        return mDb.query(BarDBActivity._TABLENAME3,
                colums,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderby);
    }
}