package ght.control.com;

import java.util.Observable;
import java.util.Observer;

import ght.model.com.BFAlgorithm;
import ght.model.com.KMPAlgorithm;

public class ConcreteKMPObserver implements Observer {
	private KMPAlgorithm KMPAlgorithm;
	private GetData getData = new GetData();

	public void update(Observable o, Object arg) {
		getData.setTextStr(((GetData) arg).getTextStr());
		getData.setPatternStr(((GetData) arg).getPatternStr());
		KMPAlgorithm = new KMPAlgorithm(getData.getTextStr(), getData.getPatternStr());
		KMPAlgorithm.mainAlgorithm();
		KMPAlgorithm.creatGson();
	}

	public KMPAlgorithm getKMPAlgorithm() {
		return KMPAlgorithm;
	}

	public void setKMPAlgorithm(KMPAlgorithm kMPAlgorithm) {
		KMPAlgorithm = kMPAlgorithm;
	}

	public GetData getGetData() {
		return getData;
	}

	public void setGetData(GetData getData) {
		this.getData = getData;
	}

}
