package ght.control.com;

import java.util.Observable;
import java.util.Observer;

import ght.model.com.BFAlgorithm;
import ght.model.com.BMAlgorithm;

public class ConcreteBMObserver implements Observer {

	private BMAlgorithm bmAlgorithm;
	private GetData getData = new GetData();

	public void update(Observable arg0, Object arg) {
		getData.setTextStr(((GetData) arg).getTextStr());
		getData.setPatternStr(((GetData) arg).getPatternStr());
		bmAlgorithm = new BMAlgorithm(getData.getTextStr(), getData.getPatternStr());
		bmAlgorithm.boyerMoore();
		bmAlgorithm.creatGson();
	}

	public BMAlgorithm getBmAlgorithm() {
		return bmAlgorithm;
	}

	public void setBmAlgorithm(BMAlgorithm bmAlgorithm) {
		this.bmAlgorithm = bmAlgorithm;
	}

	public GetData getGetData() {
		return getData;
	}

	public void setGetData(GetData getData) {
		this.getData = getData;
	}

}
