 package com.example.hikoya;

public class Version   {
    private String codeName, version;
     private  boolean  expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public Version(String codeName, String version) {
        this.codeName = codeName;
        this.version = version;
        this.expandable = false;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Version{" +
                "codeName='" + codeName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
