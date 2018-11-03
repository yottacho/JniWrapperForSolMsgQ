#pragma once
#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

	jint java_callback_send(const char *, JNIEnv *, jobject, jbyteArray, jint);
	jbyteArray java_callback_recv(const char *, JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
