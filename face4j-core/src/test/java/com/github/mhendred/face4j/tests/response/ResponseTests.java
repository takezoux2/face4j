package com.github.mhendred.face4j.tests.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.github.mhendred.face4j.exception.FaceClientException;
import com.github.mhendred.face4j.model.Photo;
import com.github.mhendred.face4j.response.GetTagsResponse;
import com.github.mhendred.face4j.response.GetTagsResponseImpl;
import com.github.mhendred.face4j.response.GroupResponse;
import com.github.mhendred.face4j.response.GroupResponseImpl;
import com.github.mhendred.face4j.response.PhotoResponse;
import com.github.mhendred.face4j.response.PhotoResponseImpl;
import com.github.mhendred.face4j.response.RemoveTagResponse;
import com.github.mhendred.face4j.response.RemoveTagResponseImpl;
import com.github.mhendred.face4j.response.SaveTagResponse;
import com.github.mhendred.face4j.response.SaveTagResponseImpl;
import com.github.mhendred.face4j.response.StatusResponse;
import com.github.mhendred.face4j.response.StatusResponseImpl;
import com.github.mhendred.face4j.response.TrainResponse;
import com.github.mhendred.face4j.response.TrainResponseImpl;
import com.github.mhendred.face4j.tests.BaseTest;


public class ResponseTests extends BaseTest
{
	public ResponseTests() throws IOException
	{
		super();
	}

	@Test
	public void photoResponse () throws FaceClientException
	{
		PhotoResponse pr = new PhotoResponseImpl(twoFaces);
		Photo p = pr.getPhoto();
		
		assertEquals(p.getFaceCount(), 2);
	}
	
	@Test
	public void trainResponse () throws FaceClientException
	{
		TrainResponse tr = new TrainResponseImpl(train);
		
		assertEquals(1, tr.getNoTrainingSet().size());
		
		assertTrue(tr.getCreated().isEmpty());
		assertTrue(tr.getInProgress().isEmpty());
		assertTrue(tr.getUnchanged().isEmpty());
		assertTrue(tr.getUpdated().isEmpty());
	}
	
	@Test
	public void removeTagResponse () throws FaceClientException
	{
		RemoveTagResponse rtr = new RemoveTagResponseImpl(removeTag);
		
		assertEquals(1,rtr.getRemovedTags().size());
	}
	
	@Test
	public void saveTagsResponse () throws FaceClientException
	{
		SaveTagResponse str = new SaveTagResponseImpl(saveTag);
		
		assertEquals(1, str.getSavedTags().size());
	}
	
	@Test
	public void statusResponse () throws FaceClientException
	{
		StatusResponse sr = new StatusResponseImpl(status);
		
		assertEquals(1, sr.getTrainingStatus().size());
	}
	
	@Test
	public void groupRespons () throws Exception
	{
		GroupResponse gr = new GroupResponseImpl(group);
		
		assertEquals(2, gr.getGroups().size());
		assertEquals(2, gr.getPhotos().size());
	}
	
	@Test
	public void getTagsResponse () throws Exception
	{
		GetTagsResponse gt = new GetTagsResponseImpl(tags);
		
		assertEquals(23, gt.getPhotos().size());
	}	
}