package com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Modules.MetaDataValidator;

import java.util.Map;

import com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Controller.Executor;


 public class MetaDataValidator 
{
	public boolean validate(Map<String,String> metaData)
	{
		if(metaData.containsKey("UUID"))
		{
			Executor.ShowAdAfterVerification(metaData);
			return true;
			
		}
		return false;
	}
}
