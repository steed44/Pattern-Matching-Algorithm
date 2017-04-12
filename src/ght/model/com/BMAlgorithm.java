package ght.model.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class BMAlgorithm {

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
	public BMAlgorithm parseGson() {
		Gson gson = new Gson();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try (BufferedReader reader = new BufferedReader(new FileReader("Gson/BM.json"))) {

			return gson.fromJson(reader, BMAlgorithm.class);
			// System.out.println(gson.toJson(bfAlog));

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return null;
	}
}
