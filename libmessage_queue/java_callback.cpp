#include "stdafx.h"
#include "jni_init.h"
#include "java_callback.h"

jint java_callback_send(const char *methodName, JNIEnv *env, jobject thisObj, jbyteArray msg, jint len)
{
	jstring strMethodName = env->NewStringUTF(methodName);

	// method id = "(arguments-type)return-type"
	/*
	* Type | Signature 
	* Z    | boolean
	* B    | byte
	* C    | char
	* S    | short
	* I    | int
	* J    | long
	* F    | float
	* D    | double
	* L<class>; | fully-qualified-class (ex. Ljava/lang/String;)
	* [<type> | array
	* (arg-types)ret-type | method type
	*/

	jclass cls = env->GetObjectClass(thisObj);
	jmethodID methodID = env->GetMethodID(cls, "CallbackRun", "(Ljava/lang/String;[BI)I");
	if (methodID == 0)
	{
		printf("Can't found 'int CallbackRun(String, byte[], int)' method in MessageQueue.java\n");
		return (jint)-1;
	}

	jint ret = env->CallIntMethod(thisObj, methodID, strMethodName, msg, len);
	if (env->ExceptionCheck())
	{
		env->ExceptionDescribe();
	}

	env->DeleteLocalRef(strMethodName);

	return ret;
}

jbyteArray java_callback_recv(const char *methodName, JNIEnv *env, jobject thisObj)
{
	jstring strMethodName = env->NewStringUTF(methodName);

	jclass cls = env->GetObjectClass(thisObj);
	jmethodID methodID = env->GetMethodID(cls, "CallbackRun", "(Ljava/lang/String;)[B");
	if (methodID == 0)
	{
		printf("Can't found 'byte[] CallbackRun(String)' method in MessageQueue.java\n");
		return emptyJbyteArray;
	}

	jbyteArray ret = (jbyteArray)env->CallObjectMethod(thisObj, methodID, strMethodName);
	if (env->ExceptionCheck())
	{
		env->ExceptionDescribe();
	}

	env->DeleteLocalRef(strMethodName);

	return ret;
}
