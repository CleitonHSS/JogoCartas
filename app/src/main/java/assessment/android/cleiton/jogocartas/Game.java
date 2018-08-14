package assessment.android.cleiton.jogocartas;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.support.design.card.MaterialCardView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class Game extends android.support.v4.app.Fragment {
    private View main;
    private MaterialCardView cartaRight;
    private MaterialCardView cartaMiddle;
    private MaterialCardView cartaLeft;
    private MaterialButton buttonMean;
    private MaterialButton buttonExit;
    private ImageView imgRight;
    private ImageView imgMiddle;
    private ImageView imgLeft;
    private ImageView imgVenceu;
    private ImageView imgErrou;
    private TextView text;
    private int select;
    private int paus;
    private boolean buttonFunc = false;
    private boolean cardStop = false;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_game, container, false);
        cartaRight =  view.findViewById(R.id.carta_right);
        cartaMiddle =  view.findViewById(R.id.carta_middle);
        cartaLeft =  view.findViewById(R.id.carta_left);
        buttonMean = view.findViewById(R.id.main_button);
        buttonExit = view.findViewById(R.id.exit_button);
        text = view.findViewById(R.id.text_game);
        imgRight = view.findViewById(R.id.img_right);
        imgMiddle = view.findViewById(R.id.img_middle);
        imgLeft = view.findViewById(R.id.img_left);
        imgVenceu =  view.findViewById(R.id.img_venceu);
        imgErrou =  view.findViewById(R.id.img_errou);

       buttonMean.setVisibility(View.INVISIBLE);
        buttonFunc = false;
        cardStop = false;
       text.setText("Selecione uma carta!");
       darCartas();

        cartaRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardStop == false ) {
                    ViewGroup.MarginLayoutParams marginR = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginR.setMargins(10, 60, 0, 0);
                    ViewGroup.MarginLayoutParams marginM = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginM.setMargins(10, 0, 10, 0);
                    ViewGroup.MarginLayoutParams marginL = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginL.setMargins(0, 0, 10, 0);

                    LinearLayout.LayoutParams layoutR = new LinearLayout.LayoutParams(marginR);
                    cartaRight.setLayoutParams(layoutR);
                    LinearLayout.LayoutParams layoutM = new LinearLayout.LayoutParams(marginM);
                    cartaMiddle.setLayoutParams(layoutM);
                    LinearLayout.LayoutParams layoutL = new LinearLayout.LayoutParams(marginL);
                    cartaLeft.setLayoutParams(layoutL);

                    buttonMean.setVisibility(View.VISIBLE);
                    buttonMean.setText("Virar Cartas");
                    text.setText("Para confirmar vire a carta!");
                    buttonFunc = true;
                    cardStop = true;

                    select = 3;
                }

            }

        });

        cartaMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardStop == false ) {
                    ViewGroup.MarginLayoutParams marginR = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginR.setMargins(10, 0, 0, 0);
                    ViewGroup.MarginLayoutParams marginM = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginM.setMargins(10, 60, 10, 0);
                    ViewGroup.MarginLayoutParams marginL = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginL.setMargins(0, 0, 10, 0);

                    LinearLayout.LayoutParams layoutR = new LinearLayout.LayoutParams(marginR);
                    cartaRight.setLayoutParams(layoutR);
                    LinearLayout.LayoutParams layoutM = new LinearLayout.LayoutParams(marginM);
                    cartaMiddle.setLayoutParams(layoutM);
                    LinearLayout.LayoutParams layoutL = new LinearLayout.LayoutParams(marginL);
                    cartaLeft.setLayoutParams(layoutL);


                    buttonMean.setVisibility(View.VISIBLE);
                    buttonMean.setText("Virar Cartas");
                    text.setText("Para confirmar, vire a carta!");
                    buttonFunc = true;
                    cardStop = true;

                    select = 2;
                }

            }


        });



        cartaLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardStop == false ) {
                    ViewGroup.MarginLayoutParams marginR = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginR.setMargins(10, 0, 0, 0);
                    ViewGroup.MarginLayoutParams marginM = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginM.setMargins(10, 0, 10, 0);
                    ViewGroup.MarginLayoutParams marginL = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginL.setMargins(0, 60, 10, 0);

                    LinearLayout.LayoutParams layoutR = new LinearLayout.LayoutParams(marginR);
                    cartaRight.setLayoutParams(layoutR);
                    LinearLayout.LayoutParams layoutM = new LinearLayout.LayoutParams(marginM);
                    cartaMiddle.setLayoutParams(layoutM);
                    LinearLayout.LayoutParams layoutL = new LinearLayout.LayoutParams(marginL);
                    cartaLeft.setLayoutParams(layoutL);

                    buttonMean.setVisibility(View.VISIBLE);
                    buttonMean.setText("Virar Cartas");
                    text.setText("Para confirmar vire as cartas!");
                    buttonFunc = true;
                    cardStop = true;

                    select = 1;
                }
            }

        });

        buttonMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonFunc == true ) {
                    imgRight.setVisibility(View.GONE);
                    imgMiddle.setVisibility(View.GONE);
                    imgLeft.setVisibility(View.GONE);

                    if (select == paus) {
                        text.setText("Você Acertou!");
                        imgVenceu.setVisibility(View.VISIBLE);
                        imgErrou.setVisibility(View.INVISIBLE);
                    } else {
                        text.setText("Você Errou!");
                        imgVenceu.setVisibility(View.INVISIBLE);
                        imgErrou.setVisibility(View.VISIBLE);
                    }
                    buttonMean.setText("Jogar Novamente");
                    buttonFunc = false;
                    cardStop = true;
                } else {
                    darCartas();
                    imgRight.setVisibility(View.VISIBLE);
                    imgMiddle.setVisibility(View.VISIBLE);
                    imgLeft.setVisibility(View.VISIBLE);
                    buttonMean.setVisibility(View.INVISIBLE);
                    imgVenceu.setVisibility(View.INVISIBLE);
                    imgErrou.setVisibility(View.INVISIBLE);
                    text.setText("Selecione uma Carta!");
                    buttonFunc = true;
                    cardStop = false;
                    select = 0;

                    ViewGroup.MarginLayoutParams marginR = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginR.setMargins(10, 0, 0, 0);
                    ViewGroup.MarginLayoutParams marginM = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginM.setMargins(10, 0, 10, 0);
                    ViewGroup.MarginLayoutParams marginL = new ViewGroup.MarginLayoutParams(cartaRight.getLayoutParams());
                    marginL.setMargins(0, 0, 10, 0);

                    LinearLayout.LayoutParams layoutR = new LinearLayout.LayoutParams(marginR);
                    cartaRight.setLayoutParams(layoutR);
                    LinearLayout.LayoutParams layoutM = new LinearLayout.LayoutParams(marginM);
                    cartaMiddle.setLayoutParams(layoutM);
                    LinearLayout.LayoutParams layoutL = new LinearLayout.LayoutParams(marginL);
                    cartaLeft.setLayoutParams(layoutL);
                }
            }

        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }

        });

        return view;
    }

    public void darCartas () {
       Random random = new Random();
        paus = random.nextInt( 4 - 1) + 1 ;
        if(paus == 1){
            cartaLeft.setBackgroundResource(R.drawable.apaus);
            cartaMiddle.setBackgroundResource(R.drawable.coringa);
            cartaRight.setBackgroundResource(R.drawable.coringa);
        } else {
                if(paus == 2) {
                    cartaLeft.setBackgroundResource(R.drawable.coringa);
                    cartaMiddle.setBackgroundResource(R.drawable.apaus);
                    cartaRight.setBackgroundResource(R.drawable.coringa);
                } else {
                        if(paus == 3) {
                            cartaLeft.setBackgroundResource(R.drawable.coringa);
                            cartaMiddle.setBackgroundResource(R.drawable.coringa);
                            cartaRight.setBackgroundResource(R.drawable.apaus);
                        }
                }
        }

    }



}
