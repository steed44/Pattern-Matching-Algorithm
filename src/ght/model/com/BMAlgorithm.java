package ght.model.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class BMAlgorithm {

	private int pLength = 0;
	private int tLength = 0;
	private String textStr, patternStr;
	private Map<String, Integer> bmBc;
	private int[] bmGs;
	private int[] suffix;
	private ArrayList<Integer> listI, listJ, listRow, listNow; // 记录i的值，j的值，和行号
	private ArrayList<Integer> listM, listN, listL;
	private ArrayList<Character> listCharI, listCharJ; // char可以存储汉字,以为他是Unicode编码,Java中的char占2个字节
	private int now = 0;
	private int i = 0, j = 0;  //i变量用于指向子串，j用于指向主串
	private int m = 0,n = 0,l = 0;  //m用于指向坏字符数字，n用于指向suffix数组，l用于指向好字符数组

	public BMAlgorithm(String textStr, String patternStr) {
		this.textStr = textStr;
		this.tLength = textStr.length();
		this.patternStr = patternStr;
		this.pLength = patternStr.length();
		bmBc = new HashMap<String, Integer>();
		bmGs = new int[pLength];
		suffix = new int[pLength];
		listI = new ArrayList<Integer>();
		listJ = new ArrayList<Integer>();
		listRow = new ArrayList<Integer>();
		listM = new ArrayList<Integer>();
		listN = new ArrayList<Integer>();
		listL = new ArrayList<Integer>();
		listNow = new ArrayList<Integer>();
		listCharI = new ArrayList<Character>();
		listCharJ = new ArrayList<Character>();
		now = 0;
	}

	// 记录算法产生的数据
	public void writeList(int i , int j, int m , int n, int l, int row) {
		listI.add(i);
		listJ.add(j);
		if (i == tLength && i != 0) {
			listCharI.add(textStr.charAt(i - 1));
		} else {
			listCharI.add(textStr.charAt(i));
		}

		if (j == pLength && j != 0) {
			listCharJ.add(patternStr.charAt(j - 1));
		} else {
			listCharJ.add(patternStr.charAt(j));
		}

		listNow.add(now);
		listRow.add(row);
		listM.add(m);
		listN.add(n);
		listL.add(l);
	}

	private void preBmBc() {
		for (i = pLength - 2; i >= 0; i--) {
			if (!bmBc.containsKey(String.valueOf(patternStr.charAt(i)))) {
				bmBc.put(String.valueOf(patternStr.charAt(i)), (Integer) (pLength - i - 1));
			}
		}
	}

	private void suffix() {
		n = pLength - 1;
		suffix[n] = pLength;
		n = 0;
		for (i = pLength - 2; i >= 0; i--) {
			n = i;
			while (n >= 0 && patternStr.charAt(n) == patternStr.charAt(pLength - 1 - i + n)) {
				n--;
			}
			suffix[i] = i - n;
		}
	}

	private void preBmGs() {
		suffix();
		// 模式串中没有子串匹配上好后缀，也找不到一个最大前缀
		for (l = 0; l < pLength; l++) {
			bmGs[l] = pLength;
		}
		// 模式串中没有子串匹配上好后缀，但找到一个最大前缀
		l = 0;
		for (n = pLength - 1; n >= 0; n--) {
			if (suffix[n] == n + 1) {
				for (; l < pLength - 1 - n; l++) {
					if (bmGs[l] == pLength) {
						bmGs[l] = pLength - 1 - n;
					}
				}
			}
		}
		// 模式串中有子串匹配上好后缀
		for (n = 0; n < pLength - 1; n++) {
			l = pLength - 1 - suffix[n];
			bmGs[l] = pLength - 1 - n;
		}
	}

	private int getBmBc(String c, int m) {
		// 如果在规则中则返回相应的值，否则返回pattern的长度
		if (bmBc.containsKey(c)) {
			return bmBc.get(c);
		} else {
			return m;
		}
	}

	public int boyerMoore() {
		preBmBc();
		preBmGs();
		j = 0;
		i = 0;
//		int count = 0;
		while (j <= tLength - pLength) {
			for (i = pLength - 1; i >= 0 && patternStr.charAt(i) == textStr.charAt(i + j); i--) { // 用于计数
//				count++;
			}
			if (i < 0) {
//				System.out.println("one position is:" + j);
				return j+1;
//				j += bmGs[0];
			} else {
				j += Math.max(bmGs[i], getBmBc(String.valueOf(textStr.charAt(i + j)), pLength) - pLength + 1 + i);
			}
		}
//		System.out.println("count:" + count);
		return -1;
	}

	// 生成json文件
	public void creatGson() {

		Gson gson = new Gson();

		System.out.println("Convert Java object to JSON format and save to file");

		try (FileWriter writer = new FileWriter("Gson/BM.json")) {

			writer.write(gson.toJson(this));

		} catch (IOException e) {

		}
	}

	// 从文件里解析json数据
	public static BMAlgorithm parseGson() {
		Gson gson = new Gson();
		System.out.println("Read JSON from file, convert JSON string back to object");
		try (BufferedReader reader = new BufferedReader(new FileReader("Gson/BM.json"))) {
			return gson.fromJson(reader, BMAlgorithm.class);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return null;
	}

	public int getpLength() {
		return pLength;
	}

	public int gettLength() {
		return tLength;
	}

	public String getTextStr() {
		return textStr;
	}

	public String getPatternStr() {
		return patternStr;
	}

	public Map<String, Integer> getBmBc() {
		return bmBc;
	}

	public int[] getBmGs() {
		return bmGs;
	}

	public int[] getSuffix() {
		return suffix;
	}

	public ArrayList<Integer> getListI() {
		return listI;
	}

	public ArrayList<Integer> getListJ() {
		return listJ;
	}

	public ArrayList<Integer> getListRow() {
		return listRow;
	}

	public ArrayList<Integer> getListNow() {
		return listNow;
	}

	public ArrayList<Character> getListCharI() {
		return listCharI;
	}

	public ArrayList<Character> getListCharJ() {
		return listCharJ;
	}

	public int getNow() {
		return now;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

}
