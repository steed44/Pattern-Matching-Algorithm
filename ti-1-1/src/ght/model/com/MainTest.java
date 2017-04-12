package ght.model.com;

import com.google.gson.Gson;

public class MainTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String aString = "abacdefgcccbbcccababaaaa";
		String bString = "ababc";
		Gson gson = new Gson();
		
		if(aString.charAt(1) == 'a'){
			System.out.println("yes");
		}
		//BF算法测试
		BFAlgorithm bfAlgorithm = new BFAlgorithm(aString, bString);
		 int  num = bfAlgorithm.mainAlgorithm();
		 bfAlgorithm.creatGson();
		 BFAlgorithm bfAlgo = bfAlgorithm.parseGson();
		 System.out.println(gson.toJson(bfAlgo));
		 System.out.println(num);
		
		
		//KMP算法测试
//		KMPAlgorithm kmpAlgorithm = new KMPAlgorithm(aString, bString);
//		int  num = kmpAlgorithm.mainAlgorithm();
//		System.out.println(num);

	}

}
