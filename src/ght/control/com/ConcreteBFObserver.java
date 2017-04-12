package ght.control.com;

import java.util.Observable;
import java.util.Observer;

import ght.model.com.BFAlgorithm;

public class ConcreteBFObserver implements Observer {

	private BFAlgorithm bfAlgorithm;
	private GetData getData = new GetData();

	public void update(Observable o, Object arg) {
		getData.setTextStr(((GetData) arg).getTextStr());
		getData.setPatternStr(((GetData) arg).getPatternStr());
		bfAlgorithm = new BFAlgorithm(getData.getTextStr(), getData.getPatternStr());
		bfAlgorithm.mainAlgorithm();
		bfAlgorithm.creatGson();
	}

	public BFAlgorithm getBfAlgorithm() {
		return bfAlgorithm;
	}

	public void setBfAlgorithm(BFAlgorithm bfAlgorithm) {
		this.bfAlgorithm = bfAlgorithm;
	}

	public GetData getGetData() {
		return getData;
	}

	public void setGetData(GetData getData) {
		this.getData = getData;
	}

}
