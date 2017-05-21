package ght.model.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.WriteAbortedException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class BFAlgorithm {
	private String textStr, patternStr; // 主串和模式串
	private int textStrLength, patternStrLength; // 主串长度和模式串长度
	private ArrayList<Integer> listI, listJ, listRow, listNow; // 记录i的值，j的值，和行号
	private ArrayList<Character> listCharI, listCharJ; // char可以存储汉字,以为他是Unicode编码,Java中的char占2个字节
	private int now = 0;
	private int i = 0, j = 0;

	public BFAlgorithm(String textStr, String patternStr) {
		this.textStr = textStr;
		this.textStrLength = textStr.length();
		this.patternStr = patternStr;
		this.patternStrLength = patternStr.length();
		listI = new ArrayList<Integer>();
		listJ = new ArrayList<Integer>();
		listRow = new ArrayList<Integer>();
		listNow = new ArrayList<Integer>();
		listCharI = new ArrayList<Character>();
		listCharJ = new ArrayList<Character>();
		now = 0;
	}

	public void writeList(int row) {
		listI.add(i);
		listJ.add(j);
		if (i == textStrLength && i != 0) {
			listCharI.add(textStr.charAt(i - 1));
		} else {
			listCharI.add(textStr.charAt(i));
		}

		if (j == patternStrLength && j != 0) {
			listCharJ.add(patternStr.charAt(j - 1));
		} else {
			listCharJ.add(patternStr.charAt(j));
		}

		listNow.add(now);
		listRow.add(row);
	}

	// BF算法主体
	public int mainAlgorithm() {
		now = 0;
		i = 0;
		j = 0;
		int count = 0;
		for (int k = 1; k <= 4; k++) {
			writeList(k);
		}
		while (i < textStrLength && j < patternStrLength) {
			writeList(5);
			if (textStr.charAt(i) == patternStr.charAt(j)) {
				writeList(6);
				++i;
				writeList(7);
				++j;
				writeList(8);
				writeList(4);
			} else {
				writeList(9);
				writeList(10);
				j = 0;
				writeList(11);
				i = ++now;
				writeList(12);
				writeList(4);
			}
			count++;
		}
		writeList(13);
		writeList(14);
		System.out.println("BF算法比较次数："+count);
		if (j == patternStrLength) {
			writeList(15);
			writeList(20);
			return now;
		} else {
			writeList(17);
			writeList(18);
			writeList(20);
			return -1;
		}
	}

	// 生成json文件
	public void creatGson() {

		Gson gson = new Gson();

		System.out.println("Convert Java object to JSON format and save to file");

		try (FileWriter writer = new FileWriter("Gson/BF.json")) {

			writer.write(gson.toJson(this));

		} catch (IOException e) {

		}

	}

	// 从文件里解析json数据
	public static BFAlgorithm parseGson() {
		Gson gson = new Gson();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try (BufferedReader reader = new BufferedReader(new FileReader("Gson/BF.json"))) {

			return gson.fromJson(reader, BFAlgorithm.class);
			// System.out.println(gson.toJson(bfAlog));

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return null;
	}

	public String getTextStr() {
		return textStr;
	}

	public String getPatternStr() {
		return patternStr;
	}

	public int getTextStrLength() {
		return textStrLength;
	}

	public int getPatternStrLength() {
		return patternStrLength;
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

}
