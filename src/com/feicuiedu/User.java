package com.feicuiedu;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����
	private int id;
	//����
	private String name;
	//���֤����
	private String idcard;
	//�Ա�
	private String sex;
	//��������
	private String birth;
	//��ַ
	private String site;
	//���
	private double balance;
	//�˻�
	private String account;
	//����
	private String password;
	//״̬
	private int state;
	//������ˮ��(����)
	private int serial;
	//Դ�˻�
	private String startAccount;
	//Ŀ���˻�
	private String targetAccount;
	//�������ͣ�1:��� 2:ȡ�� 3: ת��-֧��  4:ת��-���� ��
	private int type;
	//����ʱ��
	private String tradingHour;
	//���׽��
	private double money;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getStartAccount() {
		return startAccount;
	}
	public void setStartAccount(String startAccount) {
		this.startAccount = startAccount;
	}
	public String getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(String targetAccount) {
		this.targetAccount = targetAccount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTradingHour() {
		return tradingHour;
	}
	public void setTradingHour(String tradingHour) {
		this.tradingHour = tradingHour;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	//���ڴ����û�ʱʹ��
	public User(int id,String name, String idcard, String sex, String birth, String site,
			double balance, String account,String password) {
		this.id=id;
		this.name=name;
		this.idcard=idcard;
		this.sex=sex;
		this.birth=birth;
		this.site=site;
		this.balance=balance;
		this.account=account;
		this.password=password;
		
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	//���ڽ���ʱʹ��
	public User(int serial,String startAccount,String targetAccount,int type,String tradingHour,double money) {
		
		this.serial=serial;
		this.startAccount=startAccount;
		this.targetAccount=targetAccount;
		this.type=type;
		this.tradingHour=tradingHour;
		this.money=money;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", idcard=" + idcard + ", sex=" + sex + ", birth=" + birth
				+ ", site=" + site + ", balance=" + balance + ", account=" + account + ", password=" + password + "]";
	}
	
}