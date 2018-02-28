package com.feicuiedu;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//主键
	private int id;
	//姓名
	private String name;
	//身份证号码
	private String idcard;
	//性别
	private String sex;
	//出生日期
	private String birth;
	//地址
	private String site;
	//余额
	private double balance;
	//账户
	private String account;
	//密码
	private String password;
	//状态
	private int state;
	//账务流水号(主键)
	private int serial;
	//源账户
	private String startAccount;
	//目标账户
	private String targetAccount;
	//账务类型（1:存款 2:取款 3: 转账-支出  4:转账-收入 ）
	private int type;
	//交易时间
	private String tradingHour;
	//交易金额
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
	//用于创建用户时使用
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
	//用于交易时使用
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