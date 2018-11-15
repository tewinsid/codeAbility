package leetcode.easy;

import org.junit.Test;

/**
 *��Ŀ��
 *  ����һ�� 32 λ�з����������������е����ֽ��з�ת��
 *  �������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,  231 ? 1]������������裬�����ת�������������򷵻� 0��
 *����:
 *  ���⿼���Integer�����գ��Լ���ѧ������
 *˼·��
 *  �õ���Ŀ���ֹؼ����ǵڶ�������������������жϷ�ת֮��������Ƿ񳬹�Integer������
 *  ����˼·ʹ��ѭ�����������ݽ��л�ȡ��λ��ƴ�ӵ�������ϣ����򣬳������������ҶԸ����ĳ������쵼���˷�ʱ��
 *  ��ѭ����Ҫ�жϽ���Ƿ񳬹�����
 *      �ж�����leetcode�е�˵����https://leetcode-cn.com/problems/reverse-integer/��
 *�ؼ���
 *  ������ȡ�࣬����������Ǹ���
 *  Ҫ����result==Integer.MAX_VALUE/10�����
 */
public class ReverseInteger {

    @Test
    public void test() {
        System.out.println((double)Integer.MAX_VALUE / 10 * 8);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public int reverse(int origin) {

        int result = 0;
        while (origin != 0) {
            int pop = origin % 10;
            origin = origin / 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7 ) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8 ) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}
