package ght.model.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class KMPAlgorithm {
	private String substr, str;
	private int[] next = null;

	public KMPAlgorithm(String str, String substr) {
		this.str = str;
		this.substr = substr;
		next = new int[substr.length() + 1];
		getNext();
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
		int i = 0, j = -1;
		next[0] = -1;
		// System.out.println(substr.length());
		while (i < substr.length()) {
			if (j == -1 || substr.charAt(i) == substr.charAt(j)) {
				++i;
				++j;
				next[i] = j;
				/*
				 * 改进型算法 if(substr.charAt(i) != substr.charAt(j)){ next[i] = j;
				 * } else{ next[i] = next[j]; }
				 */
			} else {
				j = next[j];
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
	public KMPAlgorithm parseGson() {
		Gson gson = new Gson();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try (BufferedReader reader = new BufferedReader(new FileReader("Gson/KMP.json"))) {

			return gson.fromJson(reader, KMPAlgorithm.class);
			// System.out.println(gson.toJson(bfAlog));

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return null;
	}
}
