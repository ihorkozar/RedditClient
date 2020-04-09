package com.example.redditclient.ui;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;

public abstract class ViewModel extends BaseObservable {

    protected ViewModel(@Nullable State savedInstanceState) {

    }

    @CallSuper
    public void onStart() {

    }

    public State getInstanceState() {
        return new State(this);
    }

    @CallSuper
    public void onStop() {

    }

    public static class State implements Parcelable {

        public static Creator<State> CREATOR = new Creator<State>() {
            @Override
            public State createFromParcel(Parcel source) {
                return new State(source);
            }

            @Override
            public State[] newArray(int size) {
                return new State[size];
            }
        };

        protected State(ViewModel viewModel) {

        }

        public State(Parcel in) {

        }

        @Override
        public int describeContents() {
            return 0;
        }

        @CallSuper
        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    }
}