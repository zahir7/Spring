package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {

    public void show() {
       //메뉴를 표시
        showMenu();
        //콘솔에의 입력을 취득
        String inputedString = getInputedString();
        //입력문자열의 검증
        if (isValidNumber(inputedString)) {
            //처리를 실행
            execute(NumberUtils.toInt(inputedString));
        }     
    }

    abstract protected void showMenu();

    abstract protected int getMaxMenuNumber();

    abstract protected int getMinMenuNumber();

    abstract protected void execute(int number);

    protected boolean isValidNumber(String str) {        
        //문자열이 입력되어 있는가
        if (StringUtils.isBlank(str)) {
            return false;
        //수치인가
        } else if (!StringUtils.isNumeric(str)) {
            return false;
        }
        //수치이므로 int로 변환
        int number = NumberUtils.toInt(str);
        //수치가 메뉴로 표시되어 있는 번호의 범위인가
        if (getMinMenuNumber() <= number && number <= getMaxMenuNumber()) {
            return true;
        }
        return false;
    }
}
