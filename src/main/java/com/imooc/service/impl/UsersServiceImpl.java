package com.imooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.pojo.Users;
import com.imooc.service.UsersService;
import com.imooc.utils.PagedResult;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public PagedResult queryUsers(Users user, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Users> list = usersMapper.selectAll();
		PageInfo<Users> pageList = new PageInfo<>(list);
		PagedResult pagedResult = new PagedResult();
		pagedResult.setPage(page);
		pagedResult.setTotal(pageList.getPages());
		pagedResult.setRows(list);
		pagedResult.setRecords(pageList.getTotal());
		return pagedResult;
	}
}
