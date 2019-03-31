package com.imooc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.enums.VideoStatusEnum;
import com.imooc.pojo.Bgm;
import com.imooc.service.VideoService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.PagedResult;

@Controller
@RequestMapping("video")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping("/showReportList")
	public String showReportList() {
		return "video/reportList";
	}
	
	@PostMapping("/reportList")
	@ResponseBody
	public PagedResult reportList(Integer page) {
		
		PagedResult result = videoService.queryReportList(page, 10);
		return result;
	}
	
	@PostMapping("/forbidVideo")
	@ResponseBody
	public IMoocJSONResult forbidVideo(String videoId) {
		
		videoService.updateVideoStatus(videoId, VideoStatusEnum.FORBID.value);
		return IMoocJSONResult.ok();
	}

	@GetMapping("/showBgmList")
	public String showBgmList() {
		return "video/bgmList";
	}
	
	@PostMapping("/queryBgmList")
	@ResponseBody
	public PagedResult queryBgmList(Integer page) {
		return videoService.queryBgmList(page, 10);
	}
	
	@GetMapping("/showAddBgm")
	public String login() {
		return "video/addBgm";
	}
	
	@PostMapping("/addBgm")
	@ResponseBody
	public IMoocJSONResult addBgm(Bgm bgm) {
		
		videoService.addBgm(bgm);
		return IMoocJSONResult.ok();
	}
	
	@PostMapping("/delBgm")
	@ResponseBody
	public IMoocJSONResult delBgm(String bgmId) {
		videoService.deleteBgm(bgmId);
		return IMoocJSONResult.ok();
	}
	
}
