package ght.model.com;

public class BF {
	public String[] bfStrings = new String[] { "public int mainAlgorithm() {", "    int now = 0;",
			"    int i = 0, j = 0;", "    while (i<textStrLength && j<patternStrLength) {",
			"       if(textStr.charAt(i)==patternStr.charAt(j)){", "           ++i;", "           ++j;", "       }",
			"       else{", "           j=0;", "           i=++now;", "       }", "    }",
			"       if(j == patternStrLength){", "           return now;", "       }", "       else {",
			"           return -1;", "       }", "}" };
}
