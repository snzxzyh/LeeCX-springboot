package com.imooc.service.impl;

import org.springframework.stereotype.Service;

import com.imooc.pojo.Bgm;
import com.imooc.service.VideoService;
import com.imooc.utils.PagedResult;

@Service
public class VideoServiceImpl implements VideoService {


	@Override
	public void addBgm(Bgm bgm) {

	}

	@Override
	public PagedResult queryBgmList(Integer page, Integer pageSize) {
		return null;
	}

	@Override
	public void deleteBgm(String id) {

	}

	@Override
	public PagedResult queryReportList(Integer page, Integer pageSize) {
		return null;
	}

	@Override
	public void updateVideoStatus(String videoId, Integer status) {

	}
}
