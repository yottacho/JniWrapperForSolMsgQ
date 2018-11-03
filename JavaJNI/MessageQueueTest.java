
import java.lang.*;
import java.util.*;

import com.bankorea.solbus.jni.MessageQueue;

public class MessageQueueTest
{

	public static void main(String[] args)
	{
		System.out.println("libmessage_queue Windows DLL Test ...");

		long tm = System.currentTimeMillis();

		MessageQueue mq = new MessageQueue();
		byte[] data = ("" + tm).getBytes();
		System.out.println("putData => [" + new String(data) + "]");
		int ret = mq.putData(data, data.length);
		System.out.println("putData =>" + ret);

		byte[] recv = mq.getData();
		System.out.println("getData => [" + new String(recv) + "]");
	}

}
