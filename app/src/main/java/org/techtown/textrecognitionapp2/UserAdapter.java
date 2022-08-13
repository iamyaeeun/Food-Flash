package org.techtown.textrecognitionapp2;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter {
    private Context mContext;
    private SQLiteDatabase mDb;
    private UserDBActivityHelper mDbHelper;
    private String tableName="userdata";

    public UserAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new UserDBActivityHelper(mContext);
    }

    public UserAdapter createDatabase() throws SQLException
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

    public UserAdapter open() throws SQLException
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

    public void insert(int no,String food,String date){
        mDb=mDbHelper.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put("no",no);
        value.put("food",food);
        value.put("date",date);
        mDb.insert("userdata",null,value);
    }

    public void delete(int no){
        mDb=mDbHelper.getWritableDatabase();
        mDb.delete("userdata","no=?",new String[]{String.valueOf(no)});
    }

    public List getTableData(){
        try{
            String sql="SELECT * FROM "+tableName;
            List userList=new ArrayList();
            InformationData user=null;
            Cursor mCur=mDb.rawQuery(sql,null);
            if(mCur!=null){
                while(mCur.moveToNext()){
                    user=new InformationData(mCur.getInt(0),mCur.getString(1),mCur.getString(2));
                    userList.add(user);
                }
            }
            return userList;
        }catch (SQLException mSQLException){
            Log.e(TAG,"getTestData >>"+mSQLException.toString());
            throw mSQLException;
        }
    }
}
