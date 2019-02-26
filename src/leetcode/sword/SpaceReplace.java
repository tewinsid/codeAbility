package leetcode.sword;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpaceReplace {

    @Test
    public void main() {
        System.out.println(doThing("We Are Happy"));
    }

    public String doThing(String target) {
        char[] targetArray = target.toCharArray();
        int blankNumber = 0;
        for (int i = 0; i < targetArray.length; i++) {
            if (targetArray[i] == ' ') {
                blankNumber++;
            }
        }
        char[] result = new char[targetArray.length + blankNumber * 2];
        for (int i = targetArray.length - 1, j = result.length - 1; i >= 0; i--, j--) {
            if (targetArray[i] == ' ') {
                result[j] = '0';
                result[j - 1] = '2';
                result[j - 2] = '%';
                j = j - 2;
            } else {
                result[j] = targetArray[i];
            }
        }
        return String.valueOf(result);
    }
}
