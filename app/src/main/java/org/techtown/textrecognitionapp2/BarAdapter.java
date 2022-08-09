//BarAdapter.java는 BarAdapter 클래스를 담고 있음 => 데이터베이스에 접근하여 수행하는 작업들을 추상화시켜주는 역할

package org.techtown.textrecognitionapp2;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class BarAdapter {
    private Context mContext;
    private SQLiteDatabase mDb;
    private BarDBActivityHelper mDbHelper;
    private String tableName="barcodeData";

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

    public List getTableData(){
        try{
            String sql="SELECT * FROM "+tableName;
            List barList=new ArrayList();
            BarDBActivity bar=null;
            Cursor mCur=mDb.rawQuery(sql,null);
            if(mCur!=null){
                while(mCur.moveToNext()){
                    bar=new BarDBActivity();
                    bar.COL_BARCODE=mCur.getString(0);
                    bar.COL_BARNAME=mCur.getString(1);
                    barList.add(bar);
                }
            }
            return barList;
        }catch (SQLException mSQLException){
            Log.e(TAG,"getTestData >>"+mSQLException.toString());
            throw mSQLException;
        }
    }
}