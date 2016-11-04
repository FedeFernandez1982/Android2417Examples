package com.clara.rockpaperscissors;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;

/**
 * Created by admin on 11/3/16.
 */

public class Game implements Parcelable{

	String player1key;
	String player2key;
	int player1score;
	int player2score;

	Game() {}

	@Exclude
	String key;

	public Game(String player1key, String player2key, int player1score, int player2score, String key) {
		this.player1key = player1key;
		this.player2key = player2key;
		this.player1score = player1score;
		this.player2score = player2score;
		this.key = key;
	}

	protected Game(Parcel in) {
		player1key = in.readString();
		player2key = in.readString();
		player1score = in.readInt();
		player2score = in.readInt();
		key = in.readString();
	}

	public static final Creator<Game> CREATOR = new Creator<Game>() {
		@Override
		public Game createFromParcel(Parcel in) {
			return new Game(in);
		}

		@Override
		public Game[] newArray(int size) {
			return new Game[size];
		}
	};

	@Override
	public String toString() {
		return "Game{" +
				"player1key='" + player1key + '\'' +
				", player2key='" + player2key + '\'' +
				", player1score=" + player1score +
				", player2score=" + player2score +
				", key='" + key + '\'' +
				'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(player1key);
		parcel.writeString(player2key);
		parcel.writeInt(player1score);
		parcel.writeInt(player2score);
		parcel.writeString(key);
	}
}
