package cn.leancloud.demo.todo;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class Game {

  public Game() {
  }

  public Game(AVObject avObject) {
    this.icon = avObject.getString("icon");
    this.name = avObject.getString("name");
    this.desc = avObject.getString("desc");
    this.imgs = avObject.getString("imgs");
    this.imgs1 = avObject.getString("imgs1");
    this.imgs2 = avObject.getString("imgs2");
    this.apkFile = avObject.getString("apkFile");
  }

  public String name;
  public Object icon;
  public String desc;
  public Object imgs;
  public Object imgs1;
  public Object imgs2;
  public Object apkFile;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Object getImgs() {
    return imgs;
  }

  public void setImgs(String imgs) {
    this.imgs = imgs;
  }

  public Object getImgs1() {
    return imgs1;
  }

  public void setImgs1(String imgs1) {
    this.imgs1 = imgs1;
  }

  public Object getImgs2() {
    return imgs2;
  }

  public void setImgs2(String imgs2) {
    this.imgs2 = imgs2;
  }

  public Object getApkFile() {
    return apkFile;
  }

  public void setApkFile(String apkFile) {
    this.apkFile = apkFile;
  }

  public void saveInBackground(AVObject avObject, SaveCallback saveCallback) {
    avObject.put("name",name);
    avObject.put("icon",icon);
    avObject.put("desc",desc);
    avObject.put("imgs",imgs);
    avObject.put("imgs1",imgs1);
    avObject.put("imgs2",imgs2);
    avObject.put("apkFile",apkFile);
    avObject.saveInBackground(saveCallback);
  }
}
