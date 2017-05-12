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
	private ArrayList<Character> listCharI, listCharJ; // char可以存储汉字,以为他是Unicode编码,Java中的char占2个字节
	private int now = 0;
	private int i = 0, j = 0;

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
		listNow = new ArrayList<Integer>();
		listCharI = new ArrayList<Character>();
		listCharJ = new ArrayList<Character>();
		now = 0;
	}

	// 记录算法产生的数据
	public void writeList(int row) {
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
	}

	private void preBmBc() {
		for (int i = pLength - 2; i >= 0; i--) {
			if (!bmBc.containsKey(String.valueOf(patternStr.charAt(i)))) {
				bmBc.put(String.valueOf(patternStr.charAt(i)), (Integer) (pLength - i - 1));
			}
		}
	}

	private void suffix() {
		suffix[pLength - 1] = pLength;
		int q = 0;
		for (int i = pLength - 2; i >= 0; i--) {
			q = i;
			while (q >= 0 && patternStr.charAt(q) == patternStr.charAt(pLength - 1 - i + q)) {
				q--;
			}
			suffix[i] = i - q;
		}
	}

	private void preBmGs() {
		int i, j;

		suffix();
		// 模式串中没有子串匹配上好后缀，也找不到一个最大前缀
		for (i = 0; i < pLength; i++) {
			bmGs[i] = pLength;
		}
		// 模式串中没有子串匹配上好后缀，但找到一个最大前缀
		j = 0;
		for (i = pLength - 1; i >= 0; i--) {
			if (suffix[i] == i + 1) {
				for (; j < pLength - 1 - i; j++) {
					if (bmGs[j] == pLength) {
						bmGs[j] = pLength - 1 - i;
					}
				}
			}
		}
		// 模式串中有子串匹配上好后缀
		for (i = 0; i < pLength - 1; i++) {
			bmGs[pLength - 1 - suffix[i]] = pLength - 1 - i;
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
		int j = 0;
		int i = 0;
		int count = 0;
		while (j <= tLength - pLength) {
			for (i = pLength - 1; i >= 0 && patternStr.charAt(i) == textStr.charAt(i + j); i--) { // 用于计数
				count++;
			}
			if (i < 0) {
				System.out.println("one position is:" + j);
				return j+1;
//				j += bmGs[0];
			} else {
				j += Math.max(bmGs[i], getBmBc(String.valueOf(textStr.charAt(i + j)), pLength) - pLength + 1 + i);
			}
		}
		System.out.println("count:" + count);
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
