package ght.model.com;

public class BM {
	public String[] bmStrings = new String[] { "public int boyerMoore() {", "   preBmBc();", "   preBmGs();",
			"   int j = 0;", "   int i = 0;", "   int count = 0;", "   while (j <= tLength - pLength) {",
			"      for (i = pLength - 1; i >= 0 && patternStr.charAt(i) == textStr.charAt(i + j); i--) { ",
			"         count++;", "      }", "      if (i < 0) {", "         return j+1;", "      } else {",
			"         j += Math.max(bmGs[i], getBmBc(String.valueOf(textStr.charAt(i + j)), pLength) - pLength + 1 + i);",
			"      }", "   }", "   return -1;", "}", "private void preBmBc() {",
			"   for (int i = pLength - 2; i >= 0; i--) {",
			"      if (!bmBc.containsKey(String.valueOf(patternStr.charAt(i)))) {",
			"         bmBc.put(String.valueOf(patternStr.charAt(i)), (Integer) (pLength - i - 1));", "      }", "   }",
			"}", "private void suffix() {", "   suffix[pLength - 1] = pLength;", "   int q = 0;",
			"   for (int i = pLength - 2; i >= 0; i--) {", "      q = i;",
			"      while (q >= 0 && patternStr.charAt(q) == patternStr.charAt(pLength - 1 - i + q)) {", "         q--;",
			"      }", "      suffix[i] = i - q;", "   }", "}", "private void preBmGs() {", "   int i, j;",
			"   suffix();", "   for (i = 0; i < pLength; i++) {", "      bmGs[i] = pLength;", "   }", "   j = 0;",
			"   for (i = pLength - 1; i >= 0; i--) {", "      if (suffix[i] == i + 1) {",
			"         for (; j < pLength - 1 - i; j++) {", "            if (bmGs[j] == pLength) {",
			"               bmGs[j] = pLength - 1 - i;", "            }", "            }", "      }", "   }",
			"   for (i = 0; i < pLength - 1; i++) {", "      bmGs[pLength - 1 - suffix[i]] = pLength - 1 - i;", "   }",
			"}", "private int getBmBc(String c, int m) {", "   if (bmBc.containsKey(c)) {", "      return bmBc.get(c);",
			"   } else {", "      return m;", "   }", "}" };
}
