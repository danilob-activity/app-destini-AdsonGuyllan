package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.londonappbrewery.destini.models.Answer;
import com.londonappbrewery.destini.models.Story;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {


    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;

    // TODO: Declare as variaveis aqui:

    Story mT1 = new Story (R.string.T1_Story);
    Story mT2 = new Story (R.string.T2_Story);
    Story mT3 = new Story (R.string.T3_Story);
    Story mT4 = new Story (R.string.T4_End);
    Story mT5 = new Story (R.string.T5_End);
    Story mT6 = new Story (R.string.T6_End);

    Answer mAns1_T1 = new Answer (R.string.T1_Ans1);
    Answer mAns2_T1 = new Answer (R.string.T1_Ans2);

    Answer mAns1_T2 = new Answer (R.string.T2_Ans1);
    Answer mAns2_T2 = new Answer (R.string.T2_Ans2);

    Answer mAns1_T3 = new Answer (R.string.T3_Ans1);
    Answer mAns2_T3 = new Answer (R.string.T3_Ans2);


    //indice corrente da historia
    private Story mStorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //TODO: Faça o link do layout com a activity

        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerTop = findViewById(R.id.buttonTop);
        mAnswerBottom = findViewById(R.id.buttonBottom);



        //TODO:faça o mapeamento da história
        mT1.setAnswerTop(mAns1_T1);
        mT1.setAnswerBottom(mAns2_T1);

        mAns1_T1.setChildStory(mT3);
        mAns2_T1.setChildStory(mT2);

        mT3.setAnswerTop(mAns1_T3);
        mT3.setAnswerBottom(mAns2_T3);

        mAns1_T3.setChildStory(mT6);
        mAns2_T3.setChildStory(mT5);

        mT2.setAnswerTop(mAns1_T2);
        mT2.setAnswerBottom(mAns2_T2);

        mAns1_T2.setChildStory(mT3);
        mAns2_T2.setChildStory(mT4);


        if (savedInstanceState!=null){
            mStorySelected = (Story) savedInstanceState.getSerializable("StoryKey");
            if (mStorySelected.getAnswerBottom()==null) {
                mAnswerTop.setVisibility(View.GONE);
                mAnswerBottom.setVisibility(View.GONE);
            }else{
                mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
            }
        }else{
            mStorySelected = mT1;

            mStoryTextView.setText(mStorySelected.getStoryID());

            mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
        }



        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        // do botão setVisibility(View.GONE):

        mAnswerTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(mStorySelected.getAnswerTop().getChildStory());
                mStoryTextView.setText(mStorySelected.getStoryID());

                if (mStorySelected.getAnswerBottom()==null) {
                    mAnswerTop.setVisibility(View.GONE);
                    mAnswerBottom.setVisibility(View.GONE);
                }else{
                    mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                    mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
                }
            }
        });

        mAnswerBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(mStorySelected.getAnswerBottom().getChildStory());
                mStoryTextView.setText(mStorySelected.getStoryID());

                if (mStorySelected.getAnswerBottom()==null) {
                    mAnswerTop.setVisibility(View.GONE);
                    mAnswerBottom.setVisibility(View.GONE);
                }else{
                    mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                    mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
                }
            }
        });

    }
    public void updateStory(Story newStory){
        mStorySelected = newStory;

    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("StoryKey", (Serializable) mStorySelected);

    }

}
