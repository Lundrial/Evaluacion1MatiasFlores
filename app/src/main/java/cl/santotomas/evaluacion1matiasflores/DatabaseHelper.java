package cl.santotomas.evaluacion1matiasflores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLA_TARJETA = "TABLA_TARJETA";
    public static final String COLUMN_NOMBRE_TARJETA = "NOMBRE_TARJETA";
    public static final String COLUMN_NUMERO_TARJETA = "NUMERO_TARJETA";
    public static final String COLUMN_FECHA_TARJETA = "FECHA_TARJETA";
    public static final String COLUMN_ID = "ID";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "tarjetas.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + TABLA_TARJETA + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOMBRE_TARJETA + " TEXT, " + COLUMN_NUMERO_TARJETA + " TEXT, " + COLUMN_FECHA_TARJETA + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addTarjeta(ModeloTarjeta modeloTarjeta) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOMBRE_TARJETA, modeloTarjeta.getNombre());
        cv.put(COLUMN_NUMERO_TARJETA, modeloTarjeta.getNum_tarjeta());
        cv.put(COLUMN_FECHA_TARJETA, modeloTarjeta.getFecha());

        long insert = db.insert(TABLA_TARJETA, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public List<ModeloTarjeta> getTodas() {

        List<ModeloTarjeta> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM "+ TABLA_TARJETA;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int tarjetaID = cursor.getInt(0);
                String tarjetaNombre = cursor.getString(1);
                String tarjetaNumero = cursor.getString(2);
                String tarjetaFecha = cursor.getString(3);

                ModeloTarjeta newTarjeta = new ModeloTarjeta(tarjetaID, tarjetaNombre, tarjetaNumero, tarjetaFecha);
                returnList.add(newTarjeta);
            } while(cursor.moveToNext());
        } else {
            // Vacio
        }

        cursor.close();
        db.close();
        return returnList;
    }
}
