package com.hasbrain.howfastareyou;

/**
 * Created by ajatc on 15/7/2016.
 */
public class Data {

    private int mbuttonClick;
    private long mtime;

  public Data(long time, int buttonClick){
      mtime = time;
      mbuttonClick=buttonClick;
  }

    public Data(int s, long longArray) {
        mbuttonClick =s;
        mtime = longArray;

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
