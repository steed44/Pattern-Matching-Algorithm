package ght.control.com;

import java.util.Observable;

public class ConcreteSubject extends Observable {
	private GetData getData;

	public GetData getGetData() {
		return getData;
	}

	public void setGetData(GetData getData) {
		this.getData = getData;

		this.setChanged();
		this.notifyObservers(getData);
	}

}
