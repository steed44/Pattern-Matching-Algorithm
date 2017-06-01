package ght.model.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

public class BMAlgorithm {

	private int pLength = 0;
	private int tLength = 0;
	private String textStr, patternStr;
	private Map<String, Integer> bmBc;
	protected ArrayList<String> mapStr;
	protected ArrayList<Integer> mapInt;
	private int[] bmGs;
	private int[] suffix;
	protected ArrayList<Integer> bmGss, bmGsToListL;
	protected int times = 0;
	private ArrayList<Integer> listI, listJ, listRow, listNow; // 记录i的值，j的值，和行号
	private ArrayList<Integer> listM, listN, listL;
	private ArrayList<Character> listCharI, listCharJ; // char可以存储汉字,以为他是Unicode编码,Java中的char占2个字节
	private int now = 0;
	private int i = 0, j = 0; // i变量用于指向子串，j用于指向主串
	private int m = -1, n = -1, l = -1; // m用于指向坏字符数字，n用于指向suffix数组，l用于指向好字符数组

	public BMAlgorithm(String textStr, String patternStr) {
		this.textStr = textStr;
		this.tLength = textStr.length();
		this.patternStr = patternStr;
		this.pLength = patternStr.length();
		bmBc = new TreeMap<String, Integer>();
		bmGs = new int[pLength];
		for (int i = 0; i < pLength; i++) {
			bmGs[i] = -1;
		}
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
		mapInt = new ArrayList<Integer>();
		mapStr = new ArrayList<String>();
		bmGss = new ArrayList<Integer>();
		bmGsToListL = new ArrayList<Integer>();
		now = 0;
	}

	// 记录算法产生的数据
	public void writeList(int i, int j, int m, int n, int l, int row) {
		listI.add(i);
		listJ.add(j);
		if (j == tLength && j != 0) {
			listCharJ.add(textStr.charAt(j - 1));
		} else if (j >= 0 && j <tLength) {
			listCharJ.add(textStr.charAt(j));
		} else {
			listCharJ.add(' ');
		}

		if (i == pLength && i != 0) {
			listCharI.add(patternStr.charAt(i - 1));
		} else if (i >= 0) {
			listCharI.add(patternStr.charAt(i));
		} else {
			listCharI.add(' ');
		}
		if (l == -1 || l == pLength) {
			bmGsToListL.add(-1);
		} else {
			bmGsToListL.add(bmGs[l]);
		}

		listNow.add(now);
		listRow.add(row);
		listM.add(m);
		listN.add(n);
		listL.add(l);
	}

	private void preBmBc() {
		writeList(i, j, m, n, l, 20);
		for (i = pLength - 2; i >= 0; i--) {
			writeList(i, j, m, n, l, 21);
			if (!bmBc.containsKey(String.valueOf(patternStr.charAt(i)))) {
				bmBc.put(String.valueOf(patternStr.charAt(i)), (Integer) (pLength - i - 1));
				m = bmBc.size() - 1;
				mapStr.add(String.valueOf(patternStr.charAt(i)));
				mapInt.add((Integer) (pLength - i - 1));
				writeList(i, j, m, n, l, 22);
			}
			writeList(i, j, m, n, l, 23);
			writeList(i, j, m, n, l, 20);
		}
		writeList(i, j, m, n, l, 24);
		writeList(i, j, m, n, l, 3);
	}

	private void suffix() {
		writeList(i, j, m, n, l, 26);
		n = pLength - 1;
		suffix[n] = pLength;
		writeList(i, j, m, n, l, 27);
		int x = pLength - 1;
		writeList(i, j, m, x, l, 28);
		writeList(i, j, m, x, l, 29);
		for (i = pLength - 2; i >= 0; i--) {
			n = i;
			writeList(i, j, m, x, l, 30);
			writeList(i, j, m, x, l, 31);
			while (n >= 0 && patternStr.charAt(n) == patternStr.charAt(pLength - 1 - i + n)) {
				n--;
				writeList(i, j, m, x, l, 32);
				writeList(i, j, m, x, l, 31);
			}
			writeList(i, j, m, x, l, 33);
			suffix[i] = i - n;
			writeList(i, j, m, --x, l, 34);
			writeList(i, j, m, x, l, 29);
		}
		writeList(i, j, m, n, l, 35);
		writeList(i, j, m, n, l, 39);
	}

	private void writeBmGs() {
		for (int a = 0; a < pLength; a++) {
			bmGss.add(bmGs[a]);
		}
	}

	private void preBmGs() {
		writeList(i, j, m, n, l, 38);
		writeList(i, j, m, n, l, 39);
		suffix();
		writeList(i, j, m, n, l, 40);
		// 模式串中没有子串匹配上好后缀，也找不到一个最大前缀
		for (l = 0; l < pLength; l++) {
			bmGs[l] = pLength;
			writeBmGs();
			writeList(i, j, m, n, l, 41);
			writeList(i, j, m, n, l, 40);
		}
		writeList(i, j, m, n, l, 42);
		// 模式串中没有子串匹配上好后缀，但找到一个最大前缀
		l = 0;
		writeList(i, j, m, n, l, 43);
		writeList(i, j, m, n, l, 44);
		for (n = pLength - 1; n >= 0; n--) {
			writeList(i, j, m, n, l, 45);
			if (suffix[n] == n + 1) {
				writeList(i, j, m, n, l, 46);
				for (; l < pLength - 1 - n; l++) {
					writeList(i, j, m, n, l, 47);
					if (bmGs[l] == pLength) {
						bmGs[l] = pLength - 1 - n;
						writeBmGs();
						writeList(i, j, m, n, l, 48);
						writeList(i, j, m, n, l, 49);
					}
					writeList(i, j, m, n, l, 46);
				}
				writeList(i, j, m, n, l, 50);
				writeList(i, j, m, n, l, 51);
			}
			writeList(i, j, m, n, l, 44);
		}
		writeList(i, j, m, n, l, 52);
		// 模式串中有子串匹配上好后缀
		writeList(i, j, m, n, l, 53);
		for (n = 0; n < pLength - 1; n++) {
			l = pLength - 1 - suffix[n];
			bmGs[l] = pLength - 1 - n;
			writeBmGs();
			writeList(i, j, m, n, l, 54);
			writeList(i, j, m, n, l, 55);
			writeList(i, j, m, n, l, 53);
		}
		writeList(i, j, m, n, l, 56);
		writeList(i, j, m, n, l, 4);
	}

	private int getBmBc(String c, int m) {
		// 如果在规则中则返回相应的值，否则返回pattern的长度
		writeList(i, i + j, m, n, l, 58);
		if (bmBc.containsKey(c)) {
			writeList(i, i + j, m, n, l, 59);
			writeList(i, i + j, m, n, l, 15);
			return bmBc.get(c);
		} else {
			writeList(i, i + j, m, n, l, 60);
			writeList(i, i + j, m, n, l, 61);
			writeList(i, i + j, m, n, l, 15);
			return m;
		}
	}

	public int boyerMoore() {
		System.out.println("主串长度：" + tLength + "," + "子串长度:" + pLength);
		writeList(i, j, m, n, l, 1);
		writeList(i, j, m, n, l, 2);
		writeList(i, j, m, n, l, 19);
		preBmBc();
		writeList(i, j, m, n, l, 37);
		preBmGs();
		j = 0;
		writeList(i, j, m, n, l, 4);
		i = 0;
		writeList(i, j, m, n, l, 5);
		
		writeList(i, j, m, n, l, 6);
		writeList(i, j, m, n, l, 7);
		while (j <= tLength - pLength) {
			writeList(i, i + j, m, n, l, 8);
			for (i = pLength - 1; i >= 0 && patternStr.charAt(i) == textStr.charAt(i + j); i--) { // 用于计数
				times++;
				writeList(i, i + j, m, n, l, 9);
				writeList(i, i + j, m, n, l, 8);
			}
			writeList(i, i + j, m, n, l, 10);
			writeList(i, i + j, m, n, l, 11);
			if (i < 0) {
				writeList(i, i + j, m, n, l, 12);
				writeList(i, i + j, m, n, l, 1);
				// System.out.println("one position is:" + j);
				System.out.println("BM算法比较次数:" + times);
				return j + 1;
				// j += bmGs[0];
			} else {
				writeList(i, i + j, m, n, l, 13);
				times++;
				writeList(i, i + j, m, n, l, 14);
				writeList(i, i + j, m, n, l, 57);
				j += Math.max(bmGs[i], getBmBc(String.valueOf(textStr.charAt(i + j)), pLength) - pLength + 1 + i);
				now = j;
			}
			writeList(i, i + j, m, n, l, 7);
		}
		writeList(i, i + j, m, n, l, 17);
		writeList(i, i + j, m, n, l, 1);
		System.out.println("BM算法比较次数:" + times);
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
	public int getTimes() {
		return times;
	}
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public int getL() {
		return l;
	}

	public ArrayList<Integer> getListM() {
		return listM;
	}

	public ArrayList<Integer> getListN() {
		return listN;
	}

	public ArrayList<Integer> getListL() {
		return listL;
	}

	public ArrayList<String> getMapStr() {
		return mapStr;
	}

	public ArrayList<Integer> getMapInt() {
		return mapInt;
	}

	public ArrayList<Integer> getBmGss() {
		return bmGss;
	}

	public ArrayList<Integer> getBmGsToListL() {
		return bmGsToListL;
	}

}
