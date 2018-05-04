package game.com.br.squaresmarked;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Ranking extends Activity {

    SQLiteDatabase database;
    TextView fieldName1, fieldName2, fieldName3, fieldName4, fieldName5,
             fieldStar1, fieldStar2, fieldStar3, fieldStar4, fieldStar5,
             fieldLevel1, fieldLevel2,fieldLevel3, fieldLevel4,fieldLevel5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ranking );
        fieldName1 = findViewById( R.id.fieldName1 );
        fieldStar1 = findViewById( R.id.fieldStar1 );
        fieldLevel1 = findViewById( R.id.fieldLevel1 );

        fieldName2 = findViewById( R.id.fieldName2 );
        fieldStar2 = findViewById( R.id.fieldStar2 );
        fieldLevel2 = findViewById( R.id.fieldLevel2 );

        fieldName3 = findViewById( R.id.fieldName3 );
        fieldStar3 = findViewById( R.id.fieldStar3 );
        fieldLevel3 = findViewById( R.id.fieldLevel3 );

        fieldName4 = findViewById( R.id.fieldName4 );
        fieldStar4 = findViewById( R.id.fieldStar4 );
        fieldLevel4 = findViewById( R.id.fieldLevel4 );

        fieldName5 = findViewById( R.id.fieldName5 );
        fieldStar5 = findViewById( R.id.fieldStar5 );
        fieldLevel5 = findViewById( R.id.fieldLevel5 );

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int stars = extras.getInt( "stars" );
            int level = extras.getInt( "level" );
            String player = "sergio";

            writeItens( player, stars,level );
        }

        readItens();
    }


    public void writeItens(String player, int stars, int level) {
        database = openOrCreateDatabase( "db_ocean", MODE_PRIVATE, null ); //null default
        database.execSQL( "CREATE TABLE IF NOT EXISTS ranking(name VARCHAR, stars INT(8), level INT(8) )" );
        database.execSQL( "INSERT INTO ranking (name, stars,level ) values ( '" + player + "','" + stars + "','" + level + "' )" );
    }

    public void readItens() {
        database = openOrCreateDatabase( "db_ocean", MODE_PRIVATE, null ); //null default
        Cursor cursor = database.rawQuery( "SELECT * FROM ranking ORDER BY stars DESC", null );
        int nameIndex = cursor.getColumnIndex( "name" );
        int starsIndex = cursor.getColumnIndex( "stars" );
        int levelIndex = cursor.getColumnIndex( "level" );

        if (cursor != null) {
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                Log.i( "MEU LOGO", "nome jogador ->" + cursor.getString( nameIndex ) + "stars->" + cursor.getString( starsIndex ) );
                fieldName1.setText( cursor.getString( nameIndex ) );
                fieldStar1.setText( cursor.getString( starsIndex ) );
                fieldLevel1.setText( cursor.getString( levelIndex ) );
                cursor.moveToNext();

                if (!cursor.isAfterLast()) {
                    fieldName2.setText( cursor.getString( nameIndex ) );
                    fieldStar2.setText( cursor.getString( starsIndex ) );
                    fieldLevel2.setText( cursor.getString( levelIndex ) );
                    cursor.moveToNext();
                }

                if (!cursor.isAfterLast()) {
                    Log.i( "MEU LOGO", "nome jogador ->" + cursor.getString( nameIndex ) + "stars->" + cursor.getString( starsIndex ) );
                    fieldName3.setText( cursor.getString( nameIndex ) );
                    fieldStar3.setText( cursor.getString( starsIndex ) );
                    fieldLevel3.setText( cursor.getString( levelIndex ) );
                    cursor.moveToNext();
                }
                if (!cursor.isAfterLast()) {
                    Log.i( "MEU LOGO", "nome jogador ->" + cursor.getString( nameIndex ) + "stars->" + cursor.getString( starsIndex ) );
                    fieldName4.setText( cursor.getString( nameIndex ) );
                    fieldStar4.setText( cursor.getString( starsIndex ) );
                    fieldLevel4.setText( cursor.getString( levelIndex ) );
                    cursor.moveToNext();
                }

                if (!cursor.isAfterLast()) {
                    Log.i( "MEU LOGO", "nome jogador ->" + cursor.getString( nameIndex ) + "stars->" + cursor.getString( starsIndex ) );
                    fieldName5.setText( cursor.getString( nameIndex ) );
                    fieldStar5.setText( cursor.getString( starsIndex ) );
                    fieldLevel5.setText( cursor.getString( levelIndex ) );
                    cursor.moveToNext();
                }
            }
        }


    }

    public void goBack(View view) {
        Intent intent = new Intent( Ranking.this, MainActivity.class );
        startActivity( intent );
    }

}

