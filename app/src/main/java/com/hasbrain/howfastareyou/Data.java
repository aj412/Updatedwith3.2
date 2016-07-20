package com.hasbrain.howfastareyou;

/**
 * Created by ajatc on 15/7/2016.
 */
public class Data {

    private long mtime;

 //   private int buttondata;

    private int mbuttonClick;

  public Data(long time,int buttonClick){
      mtime = time;
      mbuttonClick=buttonClick;
  }

    public int getMbuttonClick() {
        return mbuttonClick;
    }

    public void setMbuttonClick(int mbuttonClick) {
        this.mbuttonClick = mbuttonClick;
    }

    public long getMtime() {
        return mtime;
    }

    public void setMtime(long mtime) {
        this.mtime = mtime;
    }

}
