package ui;

import model.Player;
import model.Team;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;

public class InsertPlayerUi extends AbstractUi {

    private TeamDao teamDao;

    private PlayerDao playerDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void setPlayerDao(PlayerDao service) {
        this.playerDao = service;
    }

    public void show() {
        final String playerName = "���� �̸�";
        //�޴��� ���ư�
        showMenu(playerName);
        //�ַܼ��� �Է� ���
        String name = getInputedString();
        //���ڿ��� �ԷµǾ� ������
        if (StringUtils.isEmpty(name)) {
            //�޴��� ���ư�
            return;
        //128���� �����ΰ�
        } else if (UiUtils.isSmallLength(name, playerName, 128)) {
            //���ο� ������ ����
            Player player = new Player();
            player.setName(name);
            //�� ����
            showTeamField(player);
        } else {
            show();
        }
    }

    protected void showTeamField(Player player) {
        final String teamId = "�� ID";
        //�޴��� ���ư�
        showMenu(teamId);
        //�ַܼ��� �Է� ���
        String id = getInputedString();
        //���ڿ��� �ԷµǾ� �ִ°�
        if (StringUtils.isEmpty(id)) {
            return;
         //��ġ�ΰ�
        } else if (UiUtils.isNumeric(id, teamId)) {
            //ID�� ���� �˻�
            Team team = this.teamDao.getTeam(Integer.valueOf(id));
            if (team == null) {
                //�ش��ϴ� ���� �������� ����
                System.out.println("�Էµ� ����" + id + "���� ���� �������� �ʽ��ϴ�.");
                showTeamField(player);
            } else {
                //���� ������ ��Ʈ
                player.setTeam(team);
                //�����ͺ��̽��� ������ ���
                playerDao.insertPlayer(player);
                System.out.println("�� ��" + team.getName() + "���� ��" + player.getName() + "�������� �߰��߽��ϴ�.");
            }
        }
    }

    protected void showMenu(String wanted) {
        System.out.println("--------------------");
        System.out.println(wanted + "�� �Է��ϰ� Enter�� ���� �ֽʽÿ�.");
        System.out.println("�ƹ��͵� �Է����� �ʰ� Enter�� ������ �޴��� ���ư��ϴ�.");
    }
}



