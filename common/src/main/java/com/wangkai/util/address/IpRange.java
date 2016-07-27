package com.wangkai.util.address;

/**
 * Created by admin on 16/7/11.
 */
public class IpRange implements Comparable<IpRange>{

    private final static long ROOT = 256 * 256 * 256;

    long lower;
    long upper;
    String district;
    private int root;

    static IpRange of(long lower, long upper, String district) {
        IpRange range = new IpRange();
        range.lower = lower;
        range.upper = upper;
        range.district = district;
        range.root = Long.valueOf(lower / ROOT).intValue();
        return range;
    }

    static IpRange of(long key) {
        return of(key, key, null);
    }

    int getRoot() {
        return root;
    }

    public int compareTo(IpRange that) {
        if (this.upper < that.lower) {
            return -1;
        } else if (this.lower > that.upper) {
            return 1;
        } else {
            return 0;
        }
    }
}
