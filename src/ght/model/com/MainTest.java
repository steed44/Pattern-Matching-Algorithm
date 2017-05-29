package ght.model.com;

import com.google.gson.Gson;

public class MainTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String aString = "abacdefgcccbbcccababaaaaasss";
		String bString = "aaaaab";
		Gson gson = new Gson();
		int num;

		if (aString.charAt(1) == 'a') {
			System.out.println("yes");
		}
		// BF算法测试
		// BFAlgorithm bfAlgorithm = new BFAlgorithm(aString, bString);
		// int num = bfAlgorithm.mainAlgorithm();
		// bfAlgorithm.creatGson();
		// BFAlgorithm bfAlgo = bfAlgorithm.parseGson();
		// System.out.println(gson.toJson(bfAlgo));
		// System.out.println(num);

		// KMP算法测试
		KMPAlgorithm kmpAlgorithm = new KMPAlgorithm(aString, bString);
		num = kmpAlgorithm.mainAlgorithm();
		System.out.println(num);
		if (num == -1) {
			System.out.println("匹配失败");
		}
		// for (int i = 0; i < 6; i++)
		// System.out.println(kmpAlgorithm.next[i]);

		// BM算法测试
		BMAlgorithm bmAlgorithm = new BMAlgorithm(aString, bString);
		num = bmAlgorithm.boyerMoore();
		System.out.println(num);
	}

}
