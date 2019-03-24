package com.cyl.musicapi;

import org.junit.Test;

public class LeetCode {

    @Test
    public void test() {

    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (true) {
            int mid = start + (end - start) / 2;
            int res = guess(mid);
            if (res == -1) {
                end = mid - 1;
            } else if (res == 0) {
                return mid;
            } else if (res == 1) {
                start = mid + 1;
            }
        }
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean res = isBadVersion(mid);
            if (res) {
                if(!isBadVersion(mid-1)){
                    return mid-1;
                }else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return 1;
    }

    /**
     * -1 : 我的数字比较小
     * 1 : 我的数字比较大
     * 0 : 恭喜！你猜对了！
     *
     * @param num
     * @return
     */
    int guess(int num) {
        return 1;
    }

    boolean isBadVersion(int num) {
        return true;
    }
}
