package com.pms.dao;

import java.util.List;

import com.pms.model.ResData;
import com.pms.model.ResRole;
import com.pms.model.ResRoleResource;
import com.pms.model.RowResourceColumn;

public interface ResourceUploadDAO {
//	ResRoleResource ResRoleResourceAdd(ResRoleResource resRoleResource) throws Exception;
//	ResFeature FeatureAdd(ResFeature feature) throws Exception;
//	ResRoleOrg ResRoleOrgAdd(ResRoleOrg resRoleOrg) throws Exception;
//	ResDataOrg ResDataOrgAdd(ResDataOrg resDataOrg) throws Exception;
//	void FeatureDel(ResFeature feature) throws Exception;
//	List<ResFeature> GetFeatureNodeByParentId(String pid, ResFeature criteria) throws Exception;
//	boolean FeatureHasChild(String pid) throws Exception;
//	int GetFeatureNodeCountByParentId(String pid) throws Exception;
//	List<ResFeature> GetAllFeatures(ResFeature criteria) throws Exception;
//	List<ResFeature> GetFeatures(String pid, ResFeature criteria, int page, int rows) throws Exception;
//	int GetFeaturesCount(ResFeature criteria) throws Exception;
//	
//	ResData DataAdd(ResData data) throws Exception;
//	void DataDel(ResData data) throws Exception;
//	List<ResData> GetDatas(List<String> resource_status, List<String> resource_type, List<String> dataset_sensitive_level,
//			List<String> data_set, List<String> section_class, List<String> element, List<String> section_relatioin_class, 
//			ResData criteria, int page, int rows) throws Exception;
//	int GetDatasCount(ResData criteria) throws Exception;
//	List<ResDataTemplate> GetDataTemplates(List<String> resource_status, List<String> resource_type, List<String> dataset_sensitive_level,
//			List<String> data_set, List<String> section_class, List<String> element, List<String> section_relatioin_class, 
//			ResDataTemplate criteria, int page, int rows) throws Exception;
//	int GetDataTemplatesCount(ResDataTemplate criteria) throws Exception;
//	ResData GetDataByRelationRow(String dataSet, String element, String elemnetValue) throws Exception;
//	ResData GetDataByRelationColumn(String dataSet, String sectionClass, String element) throws Exception;
//	List<ResData> GetDataByRelationColumnClassify(String dataSet, String sectionClass) throws Exception;
//	ResDataTemplate GetDataTemplateByRelationRow(String dataSet, String element, String elemnetValue) throws Exception;
//	ResDataTemplate GetDataTemplateByRelationColumn(String dataSet, String sectionClass, String element) throws Exception;
//	List<ResDataTemplate> GetDataTemplateByRelationColumnClassify(String dataSet, String sectionClass) throws Exception;
//	
//	ResRole RoleAdd(ResRole role) throws Exception;////////////
//	ResRole RoleImport(ResRole role) throws Exception;
//	void RoleDel(ResRole role) throws Exception;
//	List<ResRole> GetAllRoles() throws Exception;
//	List<ResRole> GetRoleById(String id) throws Exception;
//	List<ResRole> GetRolesByTime(String time) throws Exception;	
//	List<ResRole> GetRoles(ResRole criteria, int page, int rows) throws Exception;
//	int GetRolesCount(ResRole criteria) throws Exception;
//	
//	void UpdateFeatureRoleResource(String roleId, List<String> featureIds, List<String> delFeatureIds) throws Exception;
//	void UpdateDataRoleResource(String roleId, List<String> dataIds, List<String> delFeatureIds) throws Exception;
//	void UpdateDataResource(List<String> dataIds) throws Exception;
//	List<ResRoleResource> GetAllResRoles() throws Exception;
//	List<ResRoleResource> GetResRolesByTime(String time) throws Exception;
//	List<ResRoleResource> GetRoleResourcesByRoleid(String id) throws Exception;
//	ResFeature GetFeatureByResId(String id) throws Exception;
//	ResData GetDataByResId(String resId) throws Exception;
//	List<ResDataTemplate> GetDataTemplateByResId(String resId) throws Exception;
//	List<ResData> GetDataById(String id) throws Exception;
//	
//	List<ResData> GetDatasByRole(String roleId) throws Exception;
//	List<ResData> GetDatasByTime(String time) throws Exception;
//	List<ResData> GetColumnDatasByDataSet(String dataSet) throws Exception;
//	
//	ResRoleResourceImport ResRoleResourceImportAdd(ResRoleResourceImport rrri) throws Exception;
//	List<ResRoleResourceImport> GetResRoleResourceImport(int first, int count) throws Exception;
//	int ResRoleResourceImportClear() throws Exception;
//	int ClearPublicRoleAndRelationship() throws Exception;
//
//	List<ResRoleOrg> GetResRoleOrgByRoleid(String id) throws Exception;
//	List<ResDataOrg> GetResDataOrgByResId(String id) throws Exception;
//	ResData DataAddTemplate(ResData data) throws Exception;
//	ResData GetData(ResData data) throws Exception;
//	ResDataTemplate GetDataTemplate(ResData data) throws Exception;
//	
//	void UpdateDataRoleResourceTemplate(ResRoleResourceTemplate resRoleResourceTemplate, List<String> dataIds) throws Exception;
//	void UpdateFeatureRoleResourceTemplate(ResRoleResourceTemplate resRoleResourceTemplate, List<String> featureIds) throws Exception;
//	List<ResRoleResourceTemplate> GetAllResRoleResourceTemplate(int page, int rows) throws Exception;
//	int GetAllResRoleResourceTemplateCount() throws Exception;
//	void RoleResourceTemplateDel(ResRoleResourceTemplate resRoleResourceTemplate) throws Exception;
//	List<ResRoleResourceTemplate> GetResRoleResourceTemplate(ResRoleResourceTemplate resRoleResourceTemplate, int page, int rows) throws Exception;
//	int GetResRoleResourceTemplateCount(ResRoleResourceTemplate resRoleResourceTemplate) throws Exception;
//	
//	List<ResFeature> GetFuncByRoleid(String id, int page, int rows) throws Exception;
//	int GetFuncCountByRoleid(String id) throws Exception;
//	List<ResData> GetDataByRoleid(String id, int page, int rows) throws Exception;
//	int GetDataCountByRoleid(String id) throws Exception;
//	List<ResFeature> GetFeatureNodeById(String pid, ResFeature criteria) throws Exception;
	
	public ResRole DefaultRoleOfDataSetAdd(ResRole role) throws Exception;
	public ResData ImportResDataOfColumn(ResData rd) throws Exception;
	public ResRoleResource ResRoleResourceAdd(ResRoleResource resRoleResource) throws Exception;
	public ResRole GetDefaultRoleByDataSet(String dataSet, int roleType) throws Exception;
	public ResData ImportResDataOfRow(ResData rd) throws Exception;
	public ResData ImportResDataOfClassify(ResData data) throws Exception;
	public ResData ImportResDataOfClassifyRelation(ResData data) throws Exception;
	
	public List<ResData> GetDataResourcesOfClassify(String dataSet, String sectionClass, String element, int resourceType ) throws Exception;
	public List<ResData> GetDataResourcesOfColumn(String dataSet, String element, int resourceType ) throws Exception;
	public List<ResData> GetDataResourcesOfRow(String dataSet, String element, String elemnetValue, int resourceType) throws Exception;
	
	public void RowResourceColumnAdd(RowResourceColumn column) throws Exception;
	public List<RowResourceColumn> GetAllRowResourceColumns() throws Exception;
}
