package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {

    public void show() {
       //�޴��� ǥ��
        showMenu();
        //�ֿܼ��� �Է��� ���
        String inputedString = getInputedString();
        //�Է¹��ڿ��� ����
        if (isValidNumber(inputedString)) {
            //ó���� ����
            execute(NumberUtils.toInt(inputedString));
        }     
    }

    abstract protected void showMenu();

    abstract protected int getMaxMenuNumber();

    abstract protected int getMinMenuNumber();

    abstract protected void execute(int number);

    protected boolean isValidNumber(String str) {        
        //���ڿ��� �ԷµǾ� �ִ°�
        if (StringUtils.isBlank(str)) {
            return false;
        //��ġ�ΰ�
        } else if (!StringUtils.isNumeric(str)) {
            return false;
        }
        //��ġ�̹Ƿ� int�� ��ȯ
        int number = NumberUtils.toInt(str);
        //��ġ�� �޴��� ǥ�õǾ� �ִ� ��ȣ�� �����ΰ�
        if (getMinMenuNumber() <= number && number <= getMaxMenuNumber()) {
            return true;
        }
        return false;
    }
}
