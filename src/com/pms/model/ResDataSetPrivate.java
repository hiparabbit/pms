package com.pms.model;

public class ResDataSetPrivate {
	public final static int DELSTATUSNO = 0;
	public final static int DELSTATUSYES = 1;
//	public final static String DATASETTYPESOURCE = "0";//源数据
//	public final static String DATASETTYPEKNOWLN = "1";//知识库
//	public final static String DATASETTYPEFILED = "2";//备案据
	
	private int id;
	private String DATA_SET;
	private String CLUE_SRC_SYS;
	private String DATASET_NAME;
	private String DATASET_SENSITIVE_LEVEL;
	private int DELETE_STATUS;
	private int DATA_VERSION;
	private String LATEST_MOD_TIME;
//	private String DATASET_TYPE;
	
	public ResDataSetPrivate() {
	}
	public ResDataSetPrivate(ResDataSet ds) {
		id = ds.getId();
		DATA_SET = ds.getDATA_SET();
		CLUE_SRC_SYS = ds.getCLUE_SRC_SYS();
		DATASET_NAME = ds.getDATASET_NAME();
		DATASET_SENSITIVE_LEVEL = ds.getDATASET_SENSITIVE_LEVEL();
		DELETE_STATUS = ds.getDELETE_STATUS();
		DATA_VERSION = ds.getDATA_VERSION();
		LATEST_MOD_TIME = ds.getLATEST_MOD_TIME();
	}
//	public String getDATASET_TYPE() {
//		return DATASET_TYPE;
//	}
//	public void setDATASET_TYPE(String dATASET_TYPE) {
//		DATASET_TYPE = dATASET_TYPE;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDATASET_SENSITIVE_LEVEL() {
		return DATASET_SENSITIVE_LEVEL;
	}
	public void setDATASET_SENSITIVE_LEVEL(String dATASET_SENSITIVE_LEVEL) {
		DATASET_SENSITIVE_LEVEL = dATASET_SENSITIVE_LEVEL;
	}
	public String getCLUE_SRC_SYS() {
		return CLUE_SRC_SYS;
	}
	public void setCLUE_SRC_SYS(String cLUE_SRC_SYS) {
		CLUE_SRC_SYS = cLUE_SRC_SYS;
	}
	public String getDATA_SET() {
		return DATA_SET;
	}
	public void setDATA_SET(String dATA_SET) {
		DATA_SET = dATA_SET;
	}
	public String getDATASET_NAME() {
		return DATASET_NAME;
	}
	public void setDATASET_NAME(String dATASET_NAME) {
		DATASET_NAME = dATASET_NAME;
	}
	public int getDELETE_STATUS() {
		return DELETE_STATUS;
	}
	public void setDELETE_STATUS(int dELETE_STATUS) {
		DELETE_STATUS = dELETE_STATUS;
	}
	public int getDATA_VERSION() {
		return DATA_VERSION;
	}
	public void setDATA_VERSION(int dATA_VERSION) {
		DATA_VERSION = dATA_VERSION;
	}
	public String getLATEST_MOD_TIME() {
		return LATEST_MOD_TIME;
	}
	public void setLATEST_MOD_TIME(String lATEST_MOD_TIME) {
		LATEST_MOD_TIME = lATEST_MOD_TIME;
	}
	
	public boolean isValid() {
		if( (DATA_SET == null || DATA_SET.isEmpty()) 
				//|| (CLUE_SRC_SYS == null || CLUE_SRC_SYS.isEmpty()) 
				|| (DATASET_NAME == null || DATASET_NAME.isEmpty())
//				|| (DATASET_TYPE == null || DATASET_TYPE.isEmpty())
				|| (DATASET_SENSITIVE_LEVEL == null || DATASET_SENSITIVE_LEVEL.isEmpty()) ) {
			return false;
		}
		return true;
	}
}
