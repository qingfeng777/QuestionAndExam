package com.ming.service;

import java.util.List;

import com.ming.entity.FileInfo;

public interface ScoreAndFileService {

	public List<FileInfo> searchScoreByUserId(Integer userId);

}
