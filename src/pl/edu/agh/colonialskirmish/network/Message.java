package pl.edu.agh.colonialskirmish.network;

import android.os.Bundle;

public class Message {

	protected MessageType type;

	Bundle bundle = new Bundle();

	public MessageType getType() {
		return type;
	}

	public void setType( MessageType type ) {
		this.type = type;
	}

	public Bundle getBundle() {
		return bundle;
	}

	public void setBundle( Bundle bundle ) {
		this.bundle = bundle;
	}

}
