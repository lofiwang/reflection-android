package com.lofiwang.reflection;

import java.lang.reflect.Field;

/**
 * Created by lofiwang on 2018/10/11.
 */

public class ReflectionUtil {
    private static final String TAG = "ReflectionUtil";

    public static BuildConfigInfo rBuildConfig(ClassLoader classLoader, String pkgName) {
        String buildConfigName = pkgName + ".BuildConfig";
        Class buildConfigClazz = null;
        try {
            buildConfigClazz = classLoader.loadClass(buildConfigName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (buildConfigClazz == null) {
            return null;
        }
        BuildConfigInfo sdkInfo = null;
        try {
            Field debugF = buildConfigClazz.getDeclaredField("DEBUG");
            boolean debug = debugF.getBoolean(buildConfigClazz);
            Field applicationIdF = buildConfigClazz.getDeclaredField("APPLICATION_ID");
            String applicationId = (String) applicationIdF.get(buildConfigClazz);
            Field buildTypeF = buildConfigClazz.getDeclaredField("BUILD_TYPE");
            String buildType = (String) buildTypeF.get(buildConfigClazz);
            Field flavorF = buildConfigClazz.getDeclaredField("FLAVOR");
            String flavor = (String) flavorF.get(buildConfigClazz);
            Field versionCodeF = buildConfigClazz.getDeclaredField("VERSION_CODE");
            int versionCode = (int) versionCodeF.get(buildConfigClazz);
            Field versionNameF = buildConfigClazz.getDeclaredField("VERSION_NAME");
            String versionName = (String) versionNameF.get(buildConfigClazz);
            sdkInfo = new BuildConfigInfo(debug, applicationId, buildType, flavor, versionCode, versionName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdkInfo;
    }
}
