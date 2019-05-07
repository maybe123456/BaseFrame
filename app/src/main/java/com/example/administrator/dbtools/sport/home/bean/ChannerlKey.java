package com.example.administrator.dbtools.sport.home.bean;

import java.io.Serializable;

public class ChannerlKey implements Serializable {


    /**
     * id : 1
     * name : 双色球
     */
//    private String id;
//    private String name;
    private String typeId;
    private String typeName;
    private String imgurl;
    private String imgurl2;
    private String imgurl3;
    private String imgurl4;
//    private String pic;
//    private String pic2;
    private int class_id;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
//
//    public String getImgurl2() {
//        return imgurl2;
//    }
//
//    public void setImgurl2(String imgurl2) {
//        this.imgurl2 = imgurl2;
//    }

    public String getImgurl3() {
        return imgurl3;
    }

    public void setImgurl3(String imgurl3) {
        this.imgurl3 = imgurl3;
    }

    public String getImgurl4() {
        return imgurl4;
    }

    public void setImgurl4(String imgurl4) {
        this.imgurl4 = imgurl4;
    }
}
