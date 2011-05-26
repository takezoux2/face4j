package com.github.mhendred.face4j.tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public abstract class BaseTest
{
	protected final String twoFaces; 
	
	protected final String train;
	
	protected final String removeTag;
	
	protected final String saveTag;
	
	protected final String status;
	
	public BaseTest() throws IOException
	{
		twoFaces  = getJsonString("/data/faces.recognize.json");
		train     = getJsonString("/data/faces.train.json");
		saveTag   = getJsonString("/data/tags.save.json");
		removeTag = getJsonString("/data/tags.remove.json");
		status    = getJsonString("/data/tags.status.json"); 
	}
	
	private String getJsonString(String file) throws IOException
	{
		URL url = BaseTest.class.getResource(file);
		return FileUtils.readFileToString(new File(url.getFile()));
	}
}