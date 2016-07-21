package com.hasbrain.howfastareyou;

/**
 * Created by ajatc on 15/7/2016.
 */
public class Data {

    private long mtime;

 //   private int buttondata;

    private long[] mbuttonClick;

  public Data(long time, long[] buttonClick){
      mtime = time;
      mbuttonClick=buttonClick;
  }

    public long[] getMbuttonClick() {
        return mbuttonClick;
    }

    public void setMbuttonClick(long[] mbuttonClick) {
        this.mbuttonClick = mbuttonClick;
    }

    public long getMtime() {
        return mtime;
    }

    public void setMtime(long mtime) {
        this.mtime = mtime;
    }

}
