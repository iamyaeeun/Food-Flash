//BarAdapter.java는 BarAdapter 클래스를 담고 있음 => 데이터베이스에 접근하여 수행하는 작업들을 추상화시켜주는 역할을 함

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

    public BarAdapter(Context context)  //다른 클래스에서 Activity를 Context를 활용해 호출
    {
        this.mContext = context;
        mDbHelper = new BarDBActivityHelper(mContext);
    }

    public BarAdapter createDatabase() throws SQLException  //DB 생성 코드
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)  //예외 발생시 Log 출력
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public BarAdapter open() throws SQLException  //DB를 여는 코드
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)  //예외 발생시 처리 코드
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }  //DB가 닫히도록 하는 코드

    public List getTableData(){
        try{
            String sql="SELECT * FROM "+tableName;  //table 이름을 통해 바코드DB 불러옴
            List barList=new ArrayList();  //모델을 넣을 리스트 생성
            BarDBActivity bar=null;  //모델 선언
            Cursor mCur=mDb.rawQuery(sql ,null);
            if(mCur!=null){
                while(mCur.moveToNext()){  //컬럼의 마지막까지로 커서 설정
                    bar=new BarDBActivity();
                    bar.COL_BARCODE=mCur.getString(0);
                    bar.COL_BARNAME=mCur.getString(1);
                    barList.add(bar);  //리스트에 바코드 값 넣기
                }
            }
            return barList;
        }catch (SQLException mSQLException){
            Log.e(TAG,"getTestData >>"+mSQLException.toString());
            throw mSQLException;
        }
    }
}