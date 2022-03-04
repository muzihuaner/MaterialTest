package com.huangetech.materialtest

class Max {

}
fun main(){
    val a=1.0
    val b=1.5
    val c=5.1
    val largest1=max(a,b,c)
    val largest2=min(a,b,c)
    println(largest1)
    println(largest2)
}

fun <T:Comparable<T>>max(vararg nums:T): T {
    if(nums.isEmpty())throw RuntimeException("Params can not be empty!")
    var maxNum=nums[0]
    for (num in nums){
        if(num>maxNum){
            maxNum=num
        }
    }
    return maxNum
}

fun <T:Comparable<T>>min(vararg nums:T): T {
    if(nums.isEmpty())throw RuntimeException("Params can not be empty!")
    var maxNum=nums[0]
    for (num in nums){
        if(num<maxNum){
            maxNum=num
        }
    }
    return maxNum
}