#include "stdafx.h"
#include "jni_init.h"

jbyteArray emptyJbyteArray;

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved)
{
	JNIEnv *env = NULL;
	int envStat = 0;
	jbyteArray emptyJbyteArrayL = NULL;

#ifdef _M_IX86
	const char *bits = "32";
#else
	const char *bits = "64";
#endif

#ifdef _DEBUG
	const char *build = "Debug";
#else
	const char *build = "Release";
#endif

	printf("[[[[[ libmessage_queue (%sbit, %s) %s %s ]]]]]\n", bits, build, __DATE__, __TIME__);

	envStat = vm->GetEnv((void **)&env, JNI_VERSION_1_4);

	if (envStat == JNI_EDETACHED)
	{
		jint attachSts = vm->AttachCurrentThread((void **)&env, NULL);
		if (attachSts != 0)
		{
			printf("JVM AttachCurrentThread Error\n");
			vm->DestroyJavaVM();
			return 0;
		}
	}
	else if (envStat == JNI_EVERSION)
	{
		printf("JVM Version Error (1.4+)\n");
		vm->DestroyJavaVM();
		return 0;
	}

	// initialize
	emptyJbyteArrayL = env->NewByteArray(0);
	emptyJbyteArray = (jbyteArray) env->NewGlobalRef(emptyJbyteArrayL);

	vm->DetachCurrentThread();

	return JNI_VERSION_1_4;
}
