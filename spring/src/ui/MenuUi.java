package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {

    private SelectTeamUi selectTeamUi;
    //���Ӱ� �߰���
    private InsertPlayerUi insertPlayerUi;
    
    public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
         this.selectTeamUi = selectTeamUi;
    }
    //���Ӱ� �߰���
    public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
        this.insertPlayerUi = insertPlayerUi;
    }
    
    protected void showMenu() {
    	System.out.println("");
        System.out.println("--------------------");
        System.out.println("1.����");
        System.out.println("2.�� ��ü ����Ʈ");
        System.out.println("3.���� ���� �߰�");
        System.out.println("4.���� ��������");
        System.out.println("5.���� �����");
        System.out.println("");
        System.out.println("��ȣ�� �Է��ϰ� Enter�� ���� �ֽʽÿ�.");
    }
    

    protected int getMaxMenuNumber() {
        return 3;   //�����
    }

    protected int getMinMenuNumber() {
        return 1;
    }

    protected void execute(int number) {
    	System.out.println("execute");
        switch (number) {
        case 1:
            //1.����
            System.out.println("���α׷��� ����Ǿ����ϴ�.");
            System.exit(0);
        case 2:
            //2.�� ����Ʈ
            this.selectTeamUi.show();
            break;
        case 3:
            //3.�����߰�
            this.insertPlayerUi.show();
            break;
            
        case 4:
        	break;
        case 5:
        	break;
        }
        
    }

    public static void main(String[] args) {
        //Spring ���� ���� �о� ����
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = (MenuUi) context.getBean("menuUi");
        while (true) {
            menuUi.show();
        }
    }
}









