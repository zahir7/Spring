package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {

    private SelectTeamUi selectTeamUi;
    //새롭게 추가됨
    private InsertPlayerUi insertPlayerUi;
    
    public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
         this.selectTeamUi = selectTeamUi;
    }
    //새롭게 추가됨
    public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
        this.insertPlayerUi = insertPlayerUi;
    }
    
    protected void showMenu() {
    	System.out.println("");
        System.out.println("--------------------");
        System.out.println("1.종료");
        System.out.println("2.팀 전체 리스트");
        System.out.println("3.선수 정보 추가");
        System.out.println("4.팀별 선수정보");
        System.out.println("5.삭제 정상민");
        System.out.println("");
        System.out.println("번호를 입력하고 Enter를 눌러 주십시오.");
    }
    

    protected int getMaxMenuNumber() {
        return 3;   //변경됨
    }

    protected int getMinMenuNumber() {
        return 1;
    }

    protected void execute(int number) {
    	System.out.println("execute");
        switch (number) {
        case 1:
            //1.종료
            System.out.println("프로그램이 종료되었습니다.");
            System.exit(0);
        case 2:
            //2.팀 리스트
            this.selectTeamUi.show();
            break;
        case 3:
            //3.선수추가
            this.insertPlayerUi.show();
            break;
            
        case 4:
        	break;
        case 5:
        	break;
        }
        
    }

    public static void main(String[] args) {
        //Spring 설정 파일 읽어 들임
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = (MenuUi) context.getBean("menuUi");
        while (true) {
            menuUi.show();
        }
    }
}
