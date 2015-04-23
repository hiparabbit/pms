package com.pms.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.pms.dao.GroupDAO;
import com.pms.dao.impl.GroupDAOImpl;
import com.pms.dto.UserListItem;
import com.pms.model.Group;
import com.pms.model.User;

public class GroupManageService {

	public Group SaveGroupUser(Group group, List<Integer> userIds) throws Exception {
		GroupDAO dao = new GroupDAOImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.SIMPLIFIED_CHINESE);
		String timenow = sdf.format(new Date());
		group.setTstamp(timenow);
		group.setType(Group.GROUPTYPEUSER);
		group = dao.GroupAdd(group);
		
		dao.UpdateGroupUsers(group.getId(), userIds);
		return group;
	}

	public int QueryAllGroupUserItems(Group criteria, int page, int rows,
			List<Group> items) throws Exception {
		GroupDAO dao = new GroupDAOImpl();
		List<Group> res = dao.GetGroupUsers( criteria, page, rows );
		items.addAll(res);
		int total = QueryAllGroupsUsersCount( criteria );
		return total;
	}

	private int QueryAllGroupsUsersCount(Group criteria) throws Exception {
		GroupDAO dao = new GroupDAOImpl();
		int count = dao.GetGroupUsersCount( criteria );
		return count;
	}

	public List<UserListItem> QueryGroupUsersByGroupId(int id) throws Exception {
		GroupDAO dao = new GroupDAOImpl();
		List<User> users = dao.GetGroupUsersByGroupId( id );
		
		List<UserListItem> res = new ArrayList<UserListItem>();
		UserManageService ums = new UserManageService();
		UserListItem userItem = null;
		for(int i=0; i<users.size(); i++) {
			userItem = ums.ConvertUserToListItem(users.get(i));
			res.add(userItem);
		}
		
		return res;
	}

	public void DeleteGroups(List<Integer> groupIds) throws Exception {
		if(groupIds == null)
			return;
		
		Group target;
		GroupDAO dao = new GroupDAOImpl();
		for(int i = 0; i< groupIds.size(); i++) {
			target = new Group();
			target.setId(groupIds.get(i));
			dao.GroupDel(target);
		}
		
		return ;		
	}

}