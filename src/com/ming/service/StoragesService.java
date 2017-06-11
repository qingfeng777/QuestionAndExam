package com.ming.service;

import java.util.List;

import com.ming.entity.StorageInformation;
import com.ming.entity.Subject;
/**
 * 对题库的操作
 * @author 素青
 *
 */
public interface StoragesService {
	public void addStoInfo(StorageInformation storageInformation);
	public List<StorageInformation> getAllSto();
	public void saveSubject(Subject subject);
	public List<StorageInformation> getAllSub();
}
