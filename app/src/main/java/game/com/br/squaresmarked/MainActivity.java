package game.com.br.squaresmarked;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    /*Variables*/

    /*ConstraintLayout*/
    ConstraintLayout cl;
    /*images*/
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15;
    ImageView img16, img17, img18, img19, img20, img21, img22, img23, img24, img25, img26, img27, img28, img29, img30;
    ImageView imgLife;

    /*sounds*/
    MediaPlayer snStar, snLife, snError, snBonus, snClick, snIntro, snGameOver, snComplete;

    Button btnStart;

    /*Animation*/
    Animation fadeIn, fadeOut;

    /*Text*/
    TextView txtStatus, txtScore, txtLevel, txtList, txtSelected;

    /*List*/
    List<Integer> checkedList = new ArrayList<Integer>();
    List<Integer> sortList = new ArrayList<Integer>();

    /*definitions*/
    int qtdSquare = 30;
    int selected = 0;
    int cont = 0;
    int countClicks = 0;
    int numSquareCall = 5;
    int stars = 0;
    int level = 1;
    int life = 5;
    int timer = 700;
    Boolean active;
    Boolean introStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        /*Set objects*/

        /*ConstraintLayout*/
        cl = findViewById(R.id.cl);

        /*Buttons*/
        btnStart = findViewById( R.id.btnStart );

        /*sound*/
        snStar = MediaPlayer.create( getApplicationContext(), R.raw.starwin );
        snError = MediaPlayer.create( getApplicationContext(), R.raw.error );
        snLife = MediaPlayer.create( getApplicationContext(), R.raw.life );
        snIntro = MediaPlayer.create( getApplicationContext(), R.raw.intro );
        snGameOver = MediaPlayer.create( getApplicationContext(), R.raw.gameover );
        snClick = MediaPlayer.create( getApplicationContext(), R.raw.click );
        snBonus = MediaPlayer.create( getApplicationContext(), R.raw.bonus );
        snComplete = MediaPlayer.create( getApplicationContext(), R.raw.complete );

        /*Animation*/
        fadeIn = new AlphaAnimation( 0, 1 ); //show
        fadeOut = new AlphaAnimation( 1, 0 ); //hide

        /*images*/
        img1 = findViewById( R.id.img1 );
        img2 = findViewById( R.id.img2 );
        img3 = findViewById( R.id.img3 );
        img4 = findViewById( R.id.img4 );
        img5 = findViewById( R.id.img5 );
        img6 = findViewById( R.id.img6 );
        img7 = findViewById( R.id.img7 );
        img8 = findViewById( R.id.img8 );
        img9 = findViewById( R.id.img9 );
        img10 = findViewById( R.id.img10 );
        img11 = findViewById( R.id.img11 );
        img12 = findViewById( R.id.img12 );
        img13 = findViewById( R.id.img13 );
        img14 = findViewById( R.id.img14 );
        img15 = findViewById( R.id.img15 );
        img16 = findViewById( R.id.img16 );
        img17 = findViewById( R.id.img17 );
        img18 = findViewById( R.id.img18 );
        img19 = findViewById( R.id.img19 );
        img20 = findViewById( R.id.img20 );
        img21 = findViewById( R.id.img21 );
        img22 = findViewById( R.id.img22 );
        img23 = findViewById( R.id.img23 );
        img24 = findViewById( R.id.img24 );
        img25 = findViewById( R.id.img25 );
        img26 = findViewById( R.id.img26 );
        img27 = findViewById( R.id.img27 );
        img28 = findViewById( R.id.img28 );
        img29 = findViewById( R.id.img29 );
        img30 = findViewById( R.id.img30 );
        imgLife = findViewById( R.id.imgLife );

        /*text*/
        txtScore = findViewById( R.id.txtStars );
        txtLevel = findViewById( R.id.txtLevel );
        txtStatus = findViewById( R.id.txtStatus );
        txtList = findViewById( R.id.txtList );
        txtSelected = findViewById( R.id.txtSelected );


        /*Configurations OnCreate*/
        fadeIn.setDuration( timer - 500 ); //time of fadeIn
        fadeOut.setDuration( timer - 500 ); // time of fadeOut
        introStatus = true;
        txtSelected.setText( "" );
        txtList.setText( "" );
        hideSquare();
        showSquare();

        /*change background*/
        Random r = new Random(  );

        int i = r.nextInt(5);

        if (i == 0) {
            cl.setBackgroundResource(R.drawable.fundo);
        }
        if (i == 1) {
            cl.setBackgroundResource(R.drawable.fundo1);
        }
        if (i == 2) {
            cl.setBackgroundResource(R.drawable.fundo2);
        }
        if (i == 3) {
            cl.setBackgroundResource(R.drawable.fundo3);
        }
        if (i == 4) {
            cl.setBackgroundResource(R.drawable.fundo4);
        }
        if (i == 5) {
            cl.setBackgroundResource(R.drawable.fundo5);
        }


    }


    public void hideSquare() {
        img1.setVisibility( View.INVISIBLE );
        img2.setVisibility( View.INVISIBLE );
        img3.setVisibility( View.INVISIBLE );
        img4.setVisibility( View.INVISIBLE );
        img5.setVisibility( View.INVISIBLE );
        img6.setVisibility( View.INVISIBLE );
        img7.setVisibility( View.INVISIBLE );
        img8.setVisibility( View.INVISIBLE );
        img9.setVisibility( View.INVISIBLE );
        img10.setVisibility( View.INVISIBLE );
        img11.setVisibility( View.INVISIBLE );
        img12.setVisibility( View.INVISIBLE );
        img13.setVisibility( View.INVISIBLE );
        img14.setVisibility( View.INVISIBLE );
        img15.setVisibility( View.INVISIBLE );
        img16.setVisibility( View.INVISIBLE );
        img17.setVisibility( View.INVISIBLE );
        img18.setVisibility( View.INVISIBLE );
        img19.setVisibility( View.INVISIBLE );
        img20.setVisibility( View.INVISIBLE );
        img21.setVisibility( View.INVISIBLE );
        img22.setVisibility( View.INVISIBLE );
        img23.setVisibility( View.INVISIBLE );
        img24.setVisibility( View.INVISIBLE );
        img25.setVisibility( View.INVISIBLE );
        img26.setVisibility( View.INVISIBLE );
        img27.setVisibility( View.INVISIBLE );
        img28.setVisibility( View.INVISIBLE );
        img29.setVisibility( View.INVISIBLE );
        img30.setVisibility( View.INVISIBLE );
    }

    public void wrongClick(ImageView img) {
        playAudio( snError );
        img.setImageResource( R.drawable.ballblack );
        life = life - 1;
        life();
        if (life <= 0) {
            gameOver( null );
        }
        if (life >= 1) {
            countClicks = countClicks - 1;
        }
    }


    public void imageClick(ImageView img) {
        playAudio( snClick );
        checkedList.add( selected );
        countClicks = countClicks + 1;
        // txtList.setText( sortList.toString() );
        // txtSelected.setText( checkedList.toString() );

        if (sortList.contains( selected )) {
            stars = stars + 100;
            txtScore.setText( "STARS:" + stars );
            img.setImageResource( R.drawable.star );
        } else {
            wrongClick( img );
            img.setImageResource( R.drawable.ballblack );
        }

        if (active)
            Collections.sort( checkedList );
            Collections.sort( sortList );

        if (checkedList.equals( sortList )) {
            newLevel();
        } else if (checkedList.size() >= sortList.size()) {
            if (life <= 0) {
                gameOver( null );
            } else
                tryAgain();
        }

        img.setEnabled( false );
    }


    public void img1Click(View view) {
        if (active) {
            selected = 1;
            imageClick( img1 );
        }
    }

    public void img2Click(View view) {
        if (active) {
            selected = 2;
            imageClick( img2 );
        }
    }

    public void img3Click(View view) {
        if (active) {
            selected = 3;
            imageClick( img3 );
        }
    }


    public void img4Click(View view) {
        if (active) {
            selected = 4;
            imageClick( img4 );
        }
    }

    public void img5Click(View view) {
        if (active) {
            selected = 5;
            imageClick( img5 );
        }
    }

    public void img6Click(View view) {
        if (active) {
            selected = 6;
            imageClick( img6 );
        }
    }

    public void img7Click(View view) {
        if (active) {
            selected = 7;
            imageClick( img7 );
        }
    }

    public void img8Click(View view) {
        if (active) {
            selected = 8;
            imageClick( img8 );
        }
    }

    public void img9Click(View view) {
        if (active) {
            selected = 9;
            imageClick( img9 );
        }
    }

    public void img10Click(View view) {
        if (active) {
            selected = 10;
            imageClick( img10 );
        }
    }

    public void img11Click(View view) {
        if (active) {
            selected = 11;
            imageClick( img11 );
        }
    }

    public void img12Click(View view) {
        if (active) {
            selected = 12;
            imageClick( img12 );
        }
    }

    public void img13Click(View view) {
        if (active) {
            selected = 13;
            imageClick( img13 );
        }
    }

    public void img14Click(View view) {
        if (active) {
            selected = 14;
            imageClick( img14 );
        }
    }

    public void img15Click(View view) {
        if (active) {
            imageClick( img15 );
            imageClick( img15 );
        }
    }

    public void img16Click(View view) {
        if (active) {
            selected = 16;
            imageClick( img16 );
        }
    }

    public void img17Click(View view) {
        if (active) {
            selected = 17;
            imageClick( img17 );
        }
    }

    public void img18Click(View view) {
        if (active) {
            selected = 18;
            imageClick( img18 );
        }
    }

    public void img19Click(View view) {
        if (active) {
            selected = 19;
            imageClick( img19 );
        }
    }

    public void img20Click(View view) {
        if (active) {
            selected = 20;
            imageClick( img20 );
        }
    }

    public void img21Click(View view) {
        if (active) {
            selected = 21;
            imageClick( img21 );
        }
    }

    public void img22Click(View view) {
        if (active) {
            selected = 22;
            imageClick( img22 );
        }
    }

    public void img23Click(View view) {
        if (active) {
            selected = 23;
            imageClick( img23 );
        }
    }

    public void img24Click(View view) {
        if (active) {
            selected = 24;
            imageClick( img24 );
        }
    }

    public void img25Click(View view) {
        if (active) {
            selected = 25;
            imageClick( img25 );
        }
    }

    public void img26Click(View view) {
        if (active) {
            selected = 26;
            imageClick( img26 );
        }
    }


    public void img27Click(View view) {
        if (active) {
            selected = 27;
            imageClick( img27 );
        }

    }

    public void img28Click(View view) {
        if (active) {
            selected = 28;
            imageClick( img28 );
        }
    }

    public void img29Click(View view) {
        if (active) {
            selected = 29;
            imageClick( img29 );
        }
    }

    public void img30Click(View view) {
        if (active) {
            selected = 30;
            imageClick( img30 );
        }
    }


    public void showSquare() {
        runOnUiThread( new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        img1.setImageResource( R.drawable.box );
                        img2.setImageResource( R.drawable.box );
                        img3.setImageResource( R.drawable.box );
                        img4.setImageResource( R.drawable.box );
                        img5.setImageResource( R.drawable.box );
                        img6.setImageResource( R.drawable.box );
                        img7.setImageResource( R.drawable.box );
                        img8.setImageResource( R.drawable.box );
                        img9.setImageResource( R.drawable.box );
                        img10.setImageResource( R.drawable.box );
                        img11.setImageResource( R.drawable.box );
                        img12.setImageResource( R.drawable.box );
                        img13.setImageResource( R.drawable.box );
                        img14.setImageResource( R.drawable.box );
                        img15.setImageResource( R.drawable.box );
                        img16.setImageResource( R.drawable.box );
                        img17.setImageResource( R.drawable.box );
                        img18.setImageResource( R.drawable.box );
                        img19.setImageResource( R.drawable.box );
                        img20.setImageResource( R.drawable.box );
                        img21.setImageResource( R.drawable.box );
                        img22.setImageResource( R.drawable.box );
                        img23.setImageResource( R.drawable.box );
                        img24.setImageResource( R.drawable.box );
                        img25.setImageResource( R.drawable.box );
                        img26.setImageResource( R.drawable.box );
                        img27.setImageResource( R.drawable.box );
                        img28.setImageResource( R.drawable.box );
                        img29.setImageResource( R.drawable.box );
                        img30.setImageResource( R.drawable.box );

                        img1.setEnabled( true );
                        img2.setEnabled( true );
                        img3.setEnabled( true );
                        img4.setEnabled( true );
                        img5.setEnabled( true );
                        img6.setEnabled( true );
                        img7.setEnabled( true );
                        img8.setEnabled( true );
                        img9.setEnabled( true );
                        img10.setEnabled( true );
                        img11.setEnabled( true );
                        img12.setEnabled( true );
                        img13.setEnabled( true );
                        img14.setEnabled( true );
                        img15.setEnabled( true );
                        img16.setEnabled( true );
                        img17.setEnabled( true );
                        img18.setEnabled( true );
                        img19.setEnabled( true );
                        img20.setEnabled( true );
                        img21.setEnabled( true );
                        img22.setEnabled( true );
                        img23.setEnabled( true );
                        img24.setEnabled( true );
                        img25.setEnabled( true );
                        img26.setEnabled( true );
                        img27.setEnabled( true );
                        img28.setEnabled( true );
                        img29.setEnabled( true );
                        img30.setEnabled( true );

                        active = false;
                        if (introStatus)
                            txtStatus.setText( "Press Start!" );
                        else
                            txtStatus.setText( "Loading..." );

                        if (cont == 1) {
                            img1.setVisibility( View.VISIBLE );
                        }
                        if (cont == 2) {
                            img2.setVisibility( View.VISIBLE );
                        }
                        if (cont == 3) {
                            img3.setVisibility( View.VISIBLE );
                        }
                        if (cont == 4) {
                            img4.setVisibility( View.VISIBLE );
                        }
                        if (cont == 5) {
                            img5.setVisibility( View.VISIBLE );
                        }
                        if (cont == 6) {
                            img6.setVisibility( View.VISIBLE );
                        }
                        if (cont == 7) {
                            img7.setVisibility( View.VISIBLE );
                        }
                        if (cont == 8) {
                            img8.setVisibility( View.VISIBLE );
                        }
                        if (cont == 9) {
                            img9.setVisibility( View.VISIBLE );
                        }
                        if (cont == 10) {
                            img10.setVisibility( View.VISIBLE );
                        }
                        if (cont == 11) {
                            img11.setVisibility( View.VISIBLE );
                        }
                        if (cont == 12) {
                            img12.setVisibility( View.VISIBLE );
                        }
                        if (cont == 13) {
                            img13.setVisibility( View.VISIBLE );
                        }
                        if (cont == 14) {
                            img14.setVisibility( View.VISIBLE );
                        }
                        if (cont == 15) {
                            img15.setVisibility( View.VISIBLE );
                        }
                        if (cont == 16) {
                            img16.setVisibility( View.VISIBLE );
                        }
                        if (cont == 17) {
                            img17.setVisibility( View.VISIBLE );
                        }
                        if (cont == 18) {
                            img18.setVisibility( View.VISIBLE );
                        }
                        if (cont == 19) {
                            img19.setVisibility( View.VISIBLE );
                        }
                        if (cont == 20) {
                            img20.setVisibility( View.VISIBLE );
                        }
                        if (cont == 21) {
                            img21.setVisibility( View.VISIBLE );
                        }
                        if (cont == 22) {
                            img22.setVisibility( View.VISIBLE );
                        }
                        if (cont == 23) {
                            img23.setVisibility( View.VISIBLE );
                        }
                        if (cont == 24) {
                            img24.setVisibility( View.VISIBLE );
                        }
                        if (cont == 25) {
                            img25.setVisibility( View.VISIBLE );
                        }
                        if (cont == 26) {
                            img26.setVisibility( View.VISIBLE );
                        }
                        if (cont == 27) {
                            img27.setVisibility( View.VISIBLE );
                        }
                        if (cont == 28) {
                            img28.setVisibility( View.VISIBLE );
                        }
                        if (cont == 29) {
                            img29.setVisibility( View.VISIBLE );
                        }
                        if (cont == 30) {
                            img30.setVisibility( View.VISIBLE );
                        }
                        cont++;
                        if (cont <= qtdSquare)
                            showSquare();
                    }
                }, 1 );
            }
        } );
    }

    public void sortList() {
        playAudio( snIntro );
        sortList.clear();
        active = false;
        txtSelected.setText( "" );
        txtList.setText( "" );

        if (introStatus)
            txtStatus.setText( "Press Start!" );
        else
            txtStatus.setText( "Look for the stars" );

        List<Integer> numeros = new ArrayList<Integer>();
        for (int i = 1; i < qtdSquare; i++) { //Sequencia da mega sena
            numeros.add( i );
        }

        Collections.shuffle( numeros );

         for (int i = 0; i < numSquareCall; i++) {
            sortList.add( numeros.get( i ) );
        }

        for (int i = 0; i < sortList.size(); i++) {
            if (sortList.get( i ) == 1) {
                img1.setImageResource( R.drawable.star );
                delayBlink( timer, img1 );
                delayBlink( timer * 2, img1 );
                delayBlink( timer * 3, img1 );
            }


            if (sortList.get( i ) == 2) {
                img2.setImageResource( R.drawable.star );
                delayBlink( timer, img2 );
                delayBlink( timer * 2, img2 );
                delayBlink( timer * 3, img2 );
            }


            if (sortList.get( i ) == 3) {
                img3.setImageResource( R.drawable.star );
                delayBlink( timer, img3 );
                delayBlink( timer * 2, img3 );
                delayBlink( timer * 3, img3 );
            }


            if (sortList.get( i ) == 4) {
                img4.setImageResource( R.drawable.star );
                delayBlink( timer, img4 );
                delayBlink( timer * 2, img4 );
                delayBlink( timer * 3, img4 );
            }

            if (sortList.get( i ) == 5) {
                delayBlink( timer, img5 );
                delayBlink( timer * 2, img5 );
                delayBlink( timer * 3, img5 );
                img5.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 6) {
                img6.setImageResource( R.drawable.star );
                delayBlink( timer, img6 );
                delayBlink( timer * 2, img6 );
                delayBlink( timer * 3, img6 );
            }

            if (sortList.get( i ) == 7) {
                img7.setImageResource( R.drawable.star );
                delayBlink( timer, img7 );
                delayBlink( timer * 2, img7 );
                delayBlink( timer * 3, img7 );
            }

            if (sortList.get( i ) == 8) {
                img8.setImageResource( R.drawable.star );
                delayBlink( timer, img8 );
                delayBlink( timer * 2, img8 );
                delayBlink( timer * 3, img8 );
            }

            if (sortList.get( i ) == 9) {
                img9.setImageResource( R.drawable.star );
                delayBlink( timer, img9 );
                delayBlink( timer * 2, img9 );
                delayBlink( timer * 3, img9 );
            }

            if (sortList.get( i ) == 10) {
                img10.setImageResource( R.drawable.star );
                delayBlink( timer, img10 );
                delayBlink( timer * 2, img10 );
                delayBlink( timer * 3, img10 );
            }

            if (sortList.get( i ) == 11) {
                delayBlink( timer, img11 );
                delayBlink( timer * 2, img11 );
                delayBlink( timer * 3, img11 );
                img11.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 12) {
                delayBlink( timer, img12 );
                delayBlink( timer * 2, img12 );
                delayBlink( timer * 3, img12 );
                img12.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 13) {
                delayBlink( timer, img13 );
                delayBlink( timer * 2, img13 );
                delayBlink( timer * 3, img13 );
                img13.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 14) {
                delayBlink( timer, img14 );
                delayBlink( timer * 2, img14 );
                delayBlink( timer * 3, img14 );
                img14.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 15) {
                delayBlink( timer, img15 );
                delayBlink( timer * 2, img15 );
                delayBlink( timer * 3, img15 );
                img15.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 16) {
                delayBlink( timer, img16 );
                delayBlink( timer * 2, img16 );
                delayBlink( timer * 3, img16 );
                img16.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 17) {
                delayBlink( timer, img17 );
                delayBlink( timer * 2, img17 );
                delayBlink( timer * 3, img17 );
                img17.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 18) {
                delayBlink( timer, img18 );
                delayBlink( timer * 2, img18 );
                delayBlink( timer * 3, img18 );
                img18.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 19) {
                delayBlink( timer, img19 );
                delayBlink( timer * 2, img19 );
                delayBlink( timer * 3, img19 );
                img19.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 20) {
                delayBlink( timer, img20 );
                delayBlink( timer * 2, img20 );
                delayBlink( timer * 3, img20 );
                img20.setImageResource( R.drawable.star );
            }


            if (sortList.get( i ) == 21) {
                delayBlink( timer, img21 );
                delayBlink( timer * 2, img21 );
                delayBlink( timer * 3, img21 );
                img21.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 22) {
                delayBlink( timer, img22 );
                delayBlink( timer * 2, img22 );
                delayBlink( timer * 3, img22 );
                img22.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 23) {
                delayBlink( timer, img23 );
                delayBlink( timer * 2, img23 );
                delayBlink( timer * 3, img23 );
                img23.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 24) {
                delayBlink( timer, img24 );
                delayBlink( timer * 2, img24 );
                delayBlink( timer * 3, img24 );
                img24.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 25) {
                delayBlink( timer, img25 );
                delayBlink( timer * 2, img25 );
                delayBlink( timer * 3, img25 );
                img25.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 26) {
                delayBlink( timer, img26 );
                delayBlink( timer * 2, img26 );
                delayBlink( timer * 3, img26 );
                img26.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 27) {
                delayBlink( timer, img27 );
                delayBlink( timer * 2, img27 );
                delayBlink( timer * 3, img27 );
                img27.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 28) {
                delayBlink( timer, img28 );
                delayBlink( timer * 2, img28 );
                delayBlink( timer * 3, img28 );
                img28.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 29) {
                delayBlink( timer, img29 );
                delayBlink( timer * 2, img29 );
                delayBlink( timer * 3, img29 );
                img29.setImageResource( R.drawable.star );
            }

            if (sortList.get( i ) == 30) {
                delayBlink( timer, img30 );
                delayBlink( timer * 2, img30 );
                delayBlink( timer * 3, img30 );
                img30.setImageResource( R.drawable.star );
            }


        }

    }

    public void delay(final int milliseconds) {
        runOnUiThread( new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        sortList();
                    }
                }, milliseconds );
            }
        } );
    }

    public void delayBlink(final int milliseconds, final ImageView imgname) {
        runOnUiThread( new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        imgname.startAnimation( fadeOut );
                    }
                }, milliseconds );
            }
        } );
    }

    public void delayActive(final int milliseconds) {
        runOnUiThread( new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        active = true;
                        txtStatus.setText( "Find the stars hidden :)" );
                        img1.setImageResource( R.drawable.box );
                        img2.setImageResource( R.drawable.box );
                        img3.setImageResource( R.drawable.box );
                        img4.setImageResource( R.drawable.box );
                        img5.setImageResource( R.drawable.box );
                        img6.setImageResource( R.drawable.box );
                        img7.setImageResource( R.drawable.box );
                        img8.setImageResource( R.drawable.box );
                        img9.setImageResource( R.drawable.box );
                        img10.setImageResource( R.drawable.box );
                        img11.setImageResource( R.drawable.box );
                        img12.setImageResource( R.drawable.box );
                        img13.setImageResource( R.drawable.box );
                        img14.setImageResource( R.drawable.box );
                        img15.setImageResource( R.drawable.box );
                        img16.setImageResource( R.drawable.box );
                        img17.setImageResource( R.drawable.box );
                        img18.setImageResource( R.drawable.box );
                        img19.setImageResource( R.drawable.box );
                        img20.setImageResource( R.drawable.box );
                        img21.setImageResource( R.drawable.box );
                        img22.setImageResource( R.drawable.box );
                        img23.setImageResource( R.drawable.box );
                        img24.setImageResource( R.drawable.box );
                        img25.setImageResource( R.drawable.box );
                        img26.setImageResource( R.drawable.box );
                        img27.setImageResource( R.drawable.box );
                        img28.setImageResource( R.drawable.box );
                        img29.setImageResource( R.drawable.box );
                        img30.setImageResource( R.drawable.box );
                    }
                }, milliseconds * 2 );
            }
        } );
    }

    public void life() {
        if (life == 0) {
            imgLife.setImageResource( R.drawable.live0 );
        }

        if (life == 1) {
            imgLife.setImageResource( R.drawable.live1 );
        }

        if (life == 2) {
            imgLife.setImageResource( R.drawable.live2 );
        }

        if (life == 3) {
            imgLife.setImageResource( R.drawable.live3 );
        }
    }

    public void cleanSort(View view) {
        life();
        sortList.clear();
        checkedList.clear();
        countClicks = 0;
        cont = 0;
        hideSquare();
        showSquare();
        delay( timer * 1 );
        delayActive( timer * 3 );
        txtLevel.setText( "Level:" + level );
    }

    public void startGame(View view) {
        introStatus = false;
        numSquareCall = 5;
        btnStart.setVisibility( View.INVISIBLE );
        level = 1;
        txtLevel.setText( "Level:" + level );
        stars = 0;
        txtScore.setText( "STARS:" + stars );
        life = 3;
        life();
        sortList.clear();
        checkedList.clear();
        countClicks = 0;
        cont = 0;
        hideSquare();
        showSquare();
        delay( timer * 1 );
        delayActive( timer * 3 );
    }

    public void gameOver(View view) {
        playAudio( snGameOver );
        btnStart.setVisibility( View.VISIBLE );
        txtStatus.setText( "GAMEOVER" );
        txtList.setText( "" );
        txtSelected.setText( "" );
        active = false;
    }


    void newLevel() {
        AlertDialog.Builder myAlert;
        myAlert = new AlertDialog.Builder( MainActivity.this );
        myAlert.setTitle( "You Up to level " + (level + 1) );
        level = level + 1;

        if ((level % 5) == 0) {
            myAlert.setMessage( "Stage Completed! \n You Got more 1000 Stars  \n You Got one heart" );
            stars = stars + timer;
            numSquareCall = numSquareCall + 1;
            myAlert.setIcon( R.drawable.heart );

            if (life < 3)
                life = life + 1;
            timer = timer + 175;
            playAudio( snLife );
        } else {
            playAudio( snComplete );
            myAlert.setMessage( "Stage Completed! \n You Got more 250 Stars for perfect complete." );
            myAlert.setIcon( R.drawable.star );
            timer = timer - 25;
            stars = stars + 250;
        }
        myAlert.setCancelable( false );
        myAlert.setPositiveButton( "Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cleanSort( null );
            }
        } );
        myAlert.create();
        myAlert.show();
    }

    /*Audio Play*/
    public void playAudio(MediaPlayer mp) {
        if (mp != null) {
            mp.start();
        }
    }

    public void tryAgain() {
        AlertDialog.Builder myAlert;
        myAlert = new AlertDialog.Builder( MainActivity.this );
        myAlert.setTitle( "Try Again!!" );
        myAlert.setMessage( "Stage Incomplete! \n Press Try Again Button to continue" );
        myAlert.setIcon( R.drawable.box );
        myAlert.setCancelable( false );
        myAlert.setPositiveButton( "Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cleanSort( null );
            }
        } );
        myAlert.create();
        myAlert.show();
    }
}




