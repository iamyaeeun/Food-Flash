//BarDBAcivityHelper.java는 헬퍼 클래스를 담고 있음 => 데이터베이스 생성 및 관리 역할

package org.techtown.textrecognitionapp2;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.content.ContentValues.TAG;

public class BarDBActivityHelper extends SQLiteOpenHelper {  //데이터베이스 생성 및 관리

    private static String DB_PATH = "";
    private static String DB_NAME ="barcode.db";  //공공DB

    private SQLiteDatabase mDataBase;
    private Context mContext;

    public BarDBActivityHelper(Context context){
        super(context, DB_NAME, null, 1);// 1은 데이터베이스 버젼
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() throws IOException
    {
        boolean mDataBaseExist = checkDataBase();  //DB가 없으면 assets 폴더에서 복사
        if(!mDataBaseExist)
        {
            this.getReadableDatabase();
            this.close();
            try
            {
                copyDataBase();  //assets 폴더에서 DB 복사
                Log.e(TAG, "createDatabase database created");
            }
            catch (IOException mIOException)  //exception 발생시 에러코드 출력
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    private boolean checkDataBase()  //data/data/your package/databases/Da Name <-이 경로에 DB 존재하는지 확인
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    private void copyDataBase() throws IOException  //assets 폴더에서 DB 복사
    {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public void openDataBase() throws SQLException  //DB를 열어서 쿼리 작성 가능하게 만듦
    {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
    }


    @Override
    public synchronized void close()
    {
        if(mDataBase != null)  //DB가 null이 아니라면 DB 닫기
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
