package ght.model.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class KMPAlgorithm {
	private String substr, str;
	protected int[] next = null;
	protected int j, i;
	private ArrayList<Integer> listI, listJ, listRow; // 记录i的值，j的值，和行号
	private ArrayList<Character> listCharI, listCharJ; // char可以存储汉字,以为他是Unicode编码,Java中的char占2个字节

	public KMPAlgorithm(String str, String substr) {
		this.str = str;
		this.substr = substr;
		next = new int[substr.length()];
		listI = new ArrayList<Integer>();
		listJ = new ArrayList<Integer>();
		// listK = new ArrayList<Integer>();
		listRow = new ArrayList<Integer>();
		listCharI = new ArrayList<Character>();
		listCharJ = new ArrayList<Character>();
		getNextArry();
	}

	public void writeList(int i, int j,  char a, char b, int row) {
		listI.add(i);
		listJ.add(j);
		listCharI.add(a);
		listCharJ.add(b);
		listRow.add(row);
	}

	// KMP算法主体
	public int mainAlgorithm() {
		writeList(-2, -2, ' ', ' ', 19);
		writeList(i, j, ' ', ' ', 20);
		int i = 0, j = 0;
		writeList(i, j, ' ', ' ', 21);
		while (i < str.length() && j < substr.length()) {
			writeList(i, j, str.charAt(i), substr.charAt(j), 22);
			if (str.charAt(i) == substr.charAt(j)) {
				++i;
				writeList(i, j, ' ', ' ', 23);
				++j;
				writeList(i, j, ' ', ' ', 24);
				writeList(i, j, ' ', ' ', 25);
				writeList(i, j, ' ', ' ', 21);
			} else {
				writeList(i, j, ' ', ' ', 26);
				j = next[j];
				writeList(i, j, ' ', ' ', 27);
				writeList(i, j, ' ', ' ', 28);
				if (j == -1) {
					j = 0;
					writeList(i, j, ' ', ' ', 29);
					++i;
					writeList(i, j, ' ', ' ', 30);
					writeList(i, j, ' ', ' ', 31);
					writeList(i, j, ' ', ' ', 32);
					writeList(i, j, ' ', ' ', 21);
				}
				writeList(i, j, ' ', ' ', 32);
				writeList(i, j, ' ', ' ', 21);
			}
		}
		writeList(i, j, ' ', ' ', 33);
		writeList(i, j, ' ', ' ', 34);
		if (j == substr.length()) {
			writeList(i, j, ' ', ' ', 35);
			writeList(i, j, ' ', ' ', 36);
			writeList(i, j, ' ', ' ', 40);
			return i - substr.length() + 1;
		} else {
			writeList(i, j, ' ', ' ', 37);
			writeList(i, j, ' ', ' ', 38);
			writeList(i, j, ' ', ' ', 39);
			writeList(i, j, ' ', ' ', 40);
			return -1;
		}
	}

	// 计算next数组
	public void getNextArry() {
		writeList(-2, -2, ' ', ' ', 1);
		writeList(-2, -2, ' ', ' ', 2);
		j = 0;
		i = -1;
		writeList(i, j, ' ', ' ', 3);
		next[0] = -1;
		writeList(i, j, ' ', ' ',4);
		while (j < substr.length() - 1) {
			writeList(i, j, ' ', ' ', 5);
			if (i == -1 || substr.charAt(j) == substr.charAt(i)) {
				writeList(i, j, substr.charAt(j+1), substr.charAt(i+1), 6);
				if (substr.charAt(j + 1) == substr.charAt(i + 1)) {
					next[++j] = next[++i];
					writeList(i, j, ' ', ' ', 7);
					writeList(i, j, ' ', ' ', 8);
					writeList(i, j, ' ', ' ', 12);
					writeList(i, j, ' ', ' ', 4);
				} else {
					writeList(i, j, ' ', ' ', 9);
					next[++j] = ++i;
					writeList(i, j, ' ', ' ', 10);
					writeList(i, j, ' ', ' ', 11);
					writeList(i, j, ' ', ' ', 12);
					writeList(i, j, ' ', ' ', 4);
				}
			} else {
				writeList(i, j, ' ', ' ', 13);
				i = next[i];
				writeList(i, j, ' ', ' ', 14);
				writeList(i, j, ' ', ' ', 15);
				writeList(i, j, ' ', ' ', 4);
			}
		}
		writeList(i, j, ' ', ' ', 16);
		writeList(i, j, ' ', ' ', 17);
	}

	// 生成json文件
	public void creatGson() {

		Gson gson = new Gson();

		System.out.println("Convert Java object to JSON format and save to file");

		try (FileWriter writer = new FileWriter("Gson/KMP.json")) {

			writer.write(gson.toJson(this));

		} catch (IOException e) {

		}

	}

	// 从文件里解析json数据
	public static KMPAlgorithm parseGson() {
		Gson gson = new Gson();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try (BufferedReader reader = new BufferedReader(new FileReader("Gson/KMP.json"))) {

			return gson.fromJson(reader, KMPAlgorithm.class);

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return null;
	}

	public String getSubstr() {
		return substr;
	}

	public void setSubstr(String substr) {
		this.substr = substr;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public ArrayList<Integer> getListI() {
		return listI;
	}

	public void setListI(ArrayList<Integer> listI) {
		this.listI = listI;
	}

	public ArrayList<Integer> getListJ() {
		return listJ;
	}

	public void setListJ(ArrayList<Integer> listJ) {
		this.listJ = listJ;
	}

	public ArrayList<Integer> getListRow() {
		return listRow;
	}

	public void setListRow(ArrayList<Integer> listRow) {
		this.listRow = listRow;
	}

	public ArrayList<Character> getListCharI() {
		return listCharI;
	}

	public void setListCharI(ArrayList<Character> listCharI) {
		this.listCharI = listCharI;
	}

	public ArrayList<Character> getListCharJ() {
		return listCharJ;
	}

	public void setListCharJ(ArrayList<Character> listCharJ) {
		this.listCharJ = listCharJ;
	}

	public void setNext(int[] next) {
		this.next = next;
	}

	public int[] getNext() {
		return next;
	}
	
}
