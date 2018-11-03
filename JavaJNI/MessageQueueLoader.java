package com.bankorea.solbus.jni;

import java.lang.*;
import java.util.*;

public class MessageQueueLoader
{

	public static void LoadLibrary()
	{
		String osName = System.getProperty("os.name", "").toLowerCase();
		if (osName.indexOf("windows") >= 0)
		{
			String testTarget = System.getProperty("TEST_DLL_TARGET", "Debug");

			System.out.println("Windows OS detected.");
			if ("x86".equals(System.getProperty("os.arch")))
			{
				System.out.println("32bit JVM running.");
				System.loadLibrary("../" + testTarget + "/libmessage_queue");
			}
			else if ("amd64".equals(System.getProperty("os.arch")))
			{
				System.out.println("64bit JVM running.");
				System.loadLibrary("../x64/" + testTarget + "/libmessage_queue");
			}
		}
	
	}

}
