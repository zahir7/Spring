package test.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractUi {

    protected String getInputedString() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            //콘솔에의 입력를 취득
            return input.readLine();
        } catch (IOException e) {
        	return "예외발생";
        }
    }

    abstract public void show();
}