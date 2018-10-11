package com.lofiwang.reflection;

/**
 * Created by lofiwang on 2018/10/11.
 */

public class BuildConfigInfo {
    private final boolean debug;
    private final String applicationId;
    private final String buildType;
    private final String flavor;
    private final int versionCode;
    private final String versionName;

    public BuildConfigInfo(boolean debug, String applicationId, String buildType, String flavor, int versionCode, String versionName) {
        this.debug = debug;
        this.applicationId = applicationId;
        this.buildType = buildType;
        this.flavor = flavor;
        this.versionCode = versionCode;
        this.versionName = versionName;
    }


    public boolean isDebug() {
        return debug;
    }


    public String getApplicationId() {
        return applicationId;
    }


    public String getBuildType() {
        return buildType;
    }


    public String getFlavor() {
        return flavor;
    }


    public int getVersionCode() {
        return versionCode;
    }


    public String getVersionName() {
        return versionName;
    }

    @Override
    public String toString() {
        return "BuildConfigInfo{" +
                "debug=" + debug +
                ", applicationId='" + applicationId + '\'' +
                ", buildType='" + buildType + '\'' +
                ", flavor='" + flavor + '\'' +
                ", versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                '}';
    }
}
