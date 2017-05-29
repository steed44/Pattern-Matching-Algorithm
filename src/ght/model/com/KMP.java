package ght.model.com;

public class KMP {
	public String[] kmpStr = new String[] { "public void getNext() {", "    int j = 0, i = -1;", "    next[0] = -1;",
			"    while (j < substr.length() - 1) {", "        if (i == -1 || substr.charAt(j) == substr.charAt(i)) {",
			"            if (substr.charAt(j + 1) == substr.charAt(i + 1)) {", "                next[++j] = next[++i];",
			"            } ", "            else {", "                next[++j] = ++i;", "            }", "        } ",
			"        else {", "            i = next[i];", "        }", "    }", "}", "               ",
			"public int mainAlgorithm() {", "    int i = 0, j = 0;",
			"    while (i < str.length() && j < substr.length()) {", "        if (str.charAt(i) == substr.charAt(j)) {",
			"            ++i;", "            ++j;", "        } ", "        else {", "            j = next[j];",
			"            if (j == -1) {", "                j = 0;", "                ++i;", "            }",
			"        }", "    }", "    if (j == substr.length()) {", "        return i - substr.length() + 1;", "    }",
			"    else {", "        return -1;", "    }", "}" };
}
