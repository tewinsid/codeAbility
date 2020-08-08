package test.java;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class LemonHappyTest {
    @Test
    public void test() {
        double temp = 1234;
//        System.out.println("1234".split("\\.")[0]);
        System.out.println(doThing("0.123456"));
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.next());
    }


    public String getGrayCode(int len, int num) {
        String reverse = "";
        for (int i = 0; i < len; i++) {
            int temp = num % 4;
            num = num / 2;
            reverse = reverse + cacheGet(temp);
        }
        char[] reverseArray = reverse.toCharArray();
        String result = "";
        for (int i = reverseArray.length; i > 0; i--) {
            result += reverseArray[i - 1];
        }
        return result;
    }

    private static String cacheGet(int index) {
        if (index == 0) {
            return "0";
        } else if (index == 1) {
            return "1";
        } else if (index == 2) {
            return "1";
        } else if (index == 3) {
            return "0";
        } else {
            return "0";
        }
    }

    public double doThing(String nums) {
        String[] temp = nums.split("\\.");

        String zhegnshu = temp[0];

        double result = 0;
        for (int i = 0; i < zhegnshu.length(); i++) {
            result = result * 10 + Double.parseDouble(zhegnshu.substring(i, i + 1));
        }
        if (temp.length > 1) {
            String xiaoshu = temp[1];
            double xiaoshuResult = 0;
            char[] reverseArray = xiaoshu.toCharArray();
            for (int i = reverseArray.length; i > 0; i--) {
                xiaoshuResult = xiaoshuResult / 10 + Double.parseDouble(String.valueOf(reverseArray[i - 1]));
            }
            result = result + xiaoshuResult / 10;
        }

        return result;
    }

    @Test
    public void tempTest() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        date = cal.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");

        System.out.println(sf.format(date));
    }


}
