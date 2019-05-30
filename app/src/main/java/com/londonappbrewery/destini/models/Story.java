package com.londonappbrewery.destini.models;

import com.londonappbrewery.destini.models.Answer;

import java.io.Serializable;

/**
 * Created by danilo on 09/02/18.
 */

public class Story implements Serializable{
    private int mStoryID;
    Answer mAnswerTop;
    Answer mAnswerBottom;

    public Story (int id, Answer t, Answer b){
        mStoryID = id;
        mAnswerTop = t;
        mAnswerBottom = b;
    }

    public Story (int id){
        mStoryID = id;
    }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }

    public Answer getAnswerTop() {
        return mAnswerTop;
    }

    public void setAnswerTop(Answer answerTop) {
        mAnswerTop = answerTop;
    }

    public Answer getAnswerBottom() {
        return mAnswerBottom;
    }

    public void setAnswerBottom(Answer answerBottom) {
        mAnswerBottom = answerBottom;
    }

}
