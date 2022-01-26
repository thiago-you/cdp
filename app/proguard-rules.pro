# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in buildWatcher.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Firebase Crashlytics
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

#-keep class com.crashlytics.** { *; }
#-dontwarn com.crashlytics.**

# Moshi-Kotlin Rules
# required rules to compile moshi-kotlin using reflection
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.jetbrains.annotations.**
-dontwarn com.squareup.okhttp.**
-dontwarn retrofit2.Platform$Java8
-dontwarn kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
-dontwarn kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
-dontwarn kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
-dontwarn kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
-dontwarn kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
-dontwarn kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
-dontwarn kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil
-dontwarn kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor
-dontwarn kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor
-dontwarn kotlin.reflect.jvm.internal.impl.types.TypeConstructor

-keepattributes Signature
-keepattributes *Annotation*
-keepattributes Exceptions
-keepattributes JavascriptInterface

-dontnote retrofit2.Platform

-keep @android.support.annotation.Keep class * {*;}
-keep @com.squareup.moshi.JsonQualifier interface *

-keep class kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoaderImpl
-keep class kotlin.Metadata { *; }
-keep class kotlin.reflect.**
-keep class com.squareup.moshi.**
-keep class com.squareup.okhttp.** { *; }
-keep class retrofit2.converter.moshi.**
-keep class retrofit2.**
-keep class org.mp4parser.** { *; }
-keep class com.iceteck.silicompressorr.videocompression.Mp4Movie.** { *; }

-keep interface com.squareup.okhttp.** { *; }

-keep class **JsonAdapter {
    <init>(...);
    <fields>;
}

-keepnames @com.squareup.moshi.JsonClass class *

-keepclasseswithmembers class com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

-keepclassmembers @com.squareup.moshi.JsonClass class * extends java.lang.Enum {
    <fields>;
    **[] values();
}

# Keep helper method to avoid R8 optimisation that would keep all Kotlin Metadata when unwanted
-keepclassmembers class com.squareup.moshi.internal.Util {
    private static java.lang.String getKotlinMetadataClassName();
}

-keepclassmembers class kotlin.Metadata {
    public <methods>;
}

-keepclassmembers class * {
    @retrofit2.http.* <methods>;
    @com.squareup.moshi.* <methods>;
    @com.squareup.moshi.FromJson <methods>;
    @com.squareup.moshi.ToJson <methods>;
}

-keepnames @kotlin.Metadata class br.com.cconet.app.data.model.**
-keep class br.com.cconet.app.data.model.** { *; }
-keepclassmembers class br.com.cconet.app.data.model.** { *; }

-keepnames @kotlin.Metadata class br.com.cconet.app.data.network.response.**
-keep class br.com.cconet.app.data.network.response.** { *; }
-keepclassmembers class br.com.cconet.app.data.network.response.** { *; }

# keep IB Scan classes
-keep class com.integratedbiometrics.** { *; }
-dontwarn com.integratedbiometrics.**

-keep class org.libusb.** { *; }
-dontwarn org.libusb.**