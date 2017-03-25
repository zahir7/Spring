package test.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractUi {

    protected String getInputedString() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            //�ֿܼ��� �Է¸� ���
            return input.readLine();
        } catch (IOException e) {
        	return "���ܹ߻�";
        }
    }

    abstract public void show();
}