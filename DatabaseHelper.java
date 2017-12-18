package com.example.vijay.jagadeesh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by vijay on 16-Dec-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="test.db";
    private  static final int DATABAE_VERSION=1;
    private final Context context;
    SQLiteDatabase db;
    private static final String DATABASE_PATH="/data/data/com.example.vijay.jagadeesh/";

    private  final  String USER_TABLE="user";
    public DatabaseHelper(Context context) {
           super(context, DATABASE_NAME, null, DATABAE_VERSION);
        this.context=context;
        createDb();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void createDb(){
        boolean dbExist=checkDbExist();
        if (!dbExist){
            this.getReadableDatabase();
            copyDatabase();
        }


        }

    private boolean checkDbExist() {

        SQLiteDatabase sqLiteDatabase=null;
        try {
            String path = DATABASE_PATH + DATABASE_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e){

        }
        if (sqLiteDatabase!=null)
        {
            sqLiteDatabase.close();
            return  true;

        }
        return false;
    }

    private  void copyDatabase() {
        try {


            InputStream inputStream = context.getAssets().open(DATABASE_NAME);

            String outFileName = (DATABASE_PATH + DATABASE_NAME);


            OutputStream outputStream = new FileOutputStream(outFileName);



            byte[] b=new byte[1024];

            int lenght;

            while ((lenght=inputStream.read(b)) > 0){
                outputStream.write(b, 0 ,lenght);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
        private  SQLiteDatabase openDatabase(){

        String path =DATABASE_PATH + DATABASE_NAME;
        db= SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
        return  db;
        }
        public    void close(){
            if (db!=null){
                db.close();
            }
        }

    public  boolean checkUserExist(String Name,String Pass){

        String[] columns={"Name"};
        db = openDatabase();

      String selection = "Name=? and Pass=?";
      String[] selectionArgs ={Name,Pass};

        Cursor cursor=db.query(USER_TABLE,columns,selection,selectionArgs,null,null,null);
        int count= cursor.getCount();

        cursor.close();
        close();

        if (count>0){
            return  true;
        }
        else {
            return  false;
        }

        }
}
