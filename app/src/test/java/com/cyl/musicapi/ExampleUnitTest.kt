package com.cyl.musicapi

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

//        println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
//        println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
//        println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
//        println(searchInsert(intArrayOf(1, 3, 5, 6), 6))
//        println(searchInsert(intArrayOf(1, 3, 5, 6), 0))
//        println(searchInsert(intArrayOf(1, 3, 5, 6), 1))
//        println(searchInsert(intArrayOf(1, 3,x 5, 6), 3))
        val result = mySqrt(3)
//        println("${result[0]},${result[1]}")
        println("$result")
    }


    /**
     * LeetCode 35. 搜索插入位置
     * 二分查找算法
     * 一个数组，两个标记，分别从两头往中间扫描
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val middle = (low + high) / 2
            when {
                target == nums[middle] -> return middle
                target < nums[middle] -> high = middle - 1
                else -> low = middle + 1
            }
        }
        return low
    }


    /**
     * LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
     * 二分查找算法
     */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val array = intArrayOf(-1, -1)
        var low = 0
        var high = nums.size - 1
        var tmp = -1
        while (low <= high) {
            val middle = low + (-low + high) / 2
            if (target == nums[middle]) {
                //最小
                tmp = middle
                break
            } else if (
                    target < nums[middle]) {
                high = middle - 1
            } else {
                low = middle + 1
            }
        }

        if (tmp != -1) {
            array[0]= tmp
            array[1]= tmp
            while (array[0] > 0 && nums[array[0] - 1] == target) array[0]--
            while (array[1] < nums.size - 1 && nums[array[1] + 1] == target) array[1]++
        }
        return array
    }

    /**
     * x 的平方根
     */
    fun mySqrt(x: Int): Int {
            var start =0
            if(x==0||x==1) return x
            var end=  x
            while(start<end){
                val mid = start+(end-start)/2
                if(mid>x/mid){
                    end = mid
                }else{
                    start = mid+1
                }
            }
            return end-1
        }
}
