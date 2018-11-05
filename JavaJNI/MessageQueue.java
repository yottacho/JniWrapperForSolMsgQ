package com.bankorea.solbus.jni;

import java.lang.*;
import java.util.*;

public class MessageQueue
{
    public native int CPWSWAOC(byte[] msg, int len);
    public native int CPWRWAOC(byte[] msg, int len);
    public native int CP02WAOC(byte[] msg, int len);
    public native int CP03WAOC(byte[] msg, int len);
    public native int CP04WAOC(byte[] msg, int len);
    public native int CP05WAOC(byte[] msg, int len);
    public native int CP12WAOC(byte[] msg, int len);

    public native byte[] CPWRDAIC();
    public native byte[] CPWSDAIC();

    public native int CPWSDAOC(byte[] msg, int len);
    public native int CPWRDAOC(byte[] msg, int len);

    public native byte[] CPWSWAIC();

    public native int CPMADAOC(byte[] msg, int len);
    public native byte[] CPMADAIC();

    public native int CPAMDAOC(byte[] msg, int len);
    public native byte[] CPAMDAIC();

    public native int CPHFJAOC(byte[] msg, int len);
    public native byte[] CPHFNAIC();

    public native int CPBFJAOC(byte[] msg, int len);
    public native byte[] CPBFNAIC();

    public native int CPFHJAOC(byte[] msg, int len);
    public native int CPFHCAOC(byte[] msg, int len);
    public native byte[] CPFHJAIC();

    public native int CPHJNAOC(byte[] msg, int len);
    public native int CPHCNAOC(byte[] msg, int len);

    public native int CPHFJAIC(byte[] msg, int len);

    public int putData(byte[] msg, int len) {
        return CPWSDAOC(msg, len);
    }

    public byte[] getData() {
        return CPWSDAIC();
    }

    public byte[] getData(String gubun) {
        byte[] rtn_byte = null;
        if (gubun.equals("QDS2AICDR")) rtn_byte = CPWRDAIC();
        return rtn_byte;
    }

    public int putData(String gubun, byte[] data, int leng) {
        int rtn = 0;
        if (gubun.equals("QAICD2DS")) rtn = CPWRDAOC(data, leng);
        return rtn;
    }

    public int putData(String gubun, int qid, byte[] data, int leng) {
        return 0;
    }

    public native byte[] CP99EAIC();
    public native byte[] CP99AAIC();
    public native byte[] CP99VAIC();

    public native int CP99CAOC(byte[] msg, int len);
    public native int CP99AAOC(int qud, byte[] msg, int len);
    public native int CP99VAOC(int qud, byte[] msg, int len);

    static {
        //System.loadLibrary("message_queue");
        //System.load("/home1/OnlineSys/solbus/lib/libmessage_queue.sl");

		MessageQueueLoader.LoadLibrary();
    }

	public int CallbackRun(String methodNm, byte[] msg, int len)
	{
		System.out.println("Callback method!! A -->" + methodNm + "-> " + len);
		System.out.println("Callback method!! A -->[" + new String(msg) + "]");

		return len;
	}

	public byte[] CallbackRun(String methodNm)
	{
		long tm = System.currentTimeMillis();
		System.out.println("Callback method!! B -->" + methodNm + "-> " + tm);

		return ("" + tm).getBytes();
	}
}
