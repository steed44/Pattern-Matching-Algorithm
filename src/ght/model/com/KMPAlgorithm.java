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
		getNext();
	}

	public void writeList(int m, int n, int row, char a, char b) {
		listI.add(m);
		listJ.add(n);
		listCharI.add(a);
		listCharJ.add(b);
		listRow.add(row);
	}

	// KMP算法主体
	public int mainAlgorithm() {
		int i = 0, j = 0;
		while (i < str.length() && j < substr.length()) {
			if (str.charAt(i) == substr.charAt(j)) {
				++i;
				++j;
			} else {
				j = next[j];
				if (j == -1) {
					j = 0;
					++i;
				}
			}
		}
		if (j == substr.length()) {
			return i - substr.length() + 1;
		} else {
			return -1;
		}
	}

	// 计算next数组
	public void getNext() {
		j = 0;
		i = -1;
		next[0] = -1;
		while (j < substr.length() - 1) {
			if (i == -1 || substr.charAt(j) == substr.charAt(i)) {
				if (substr.charAt(j + 1) == substr.charAt(i + 1)) {
					next[++j] = next[++i];
				} else {
					next[++j] = ++i;
				}
			} else {
				i = next[i];
			}
		}
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
}
