package ui;

import org.apache.commons.lang.StringUtils;

public class UiUtils {

    public static boolean isSmallLength(String name, String fieldName, int length) {

        if (name == null) {
            return true;
        }

        if (length < name.length()) {
            System.out.println(fieldName + "��" + length + "���� ���Ϸ� �Է��� �ֽʽÿ�.");
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str, String fieldName) {
    	//��ġ�ΰ�
        if (!StringUtils.isNumeric(str)) {
            System.out.println(fieldName + "�� ���ڷ� �Է��� �ֽʽÿ�.");
            return false;
        }
        return true;
    }
}
