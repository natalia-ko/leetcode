package com.leetcode;

import java.util.Arrays;

/*Generate Random Point in a Circle
Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.
Note:
-input and output values are in floating-point.
-radius and x-y position of the center of the circle is passed into the class constructor.
-a point on the circumference of the circle is considered to be in the circle.
-randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
Example 1:
Input:
["Solution","randPoint","randPoint","randPoint"]
[[1,0,0],[],[],[]]
Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
Example 2:
Input:
["Solution","randPoint","randPoint","randPoint"]
[[10,5,-7.5],[],[],[]]
Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
Explanation of Input Syntax:
The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments, the radius, x-position of the center,
and y-position of the center of the circle. randPoint has no arguments. Arguments are always wrapped with a list, even if there aren't any.*/
public class S_0478_GenerateRandomPointInACircle {
    double radius;
    double x_center;
    double y_center;

    public S_0478_GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double ang = Math.random() * 2 * Math.PI,
                c = Math.sqrt(Math.random()) * radius,
                a = Math.cos(ang) * c,
                b = Math.sin(ang) * c;
        return new double[]{x_center + a, y_center + b};
    }


    public static void main(String[] args) {
        S_0478_GenerateRandomPointInACircle obj = new S_0478_GenerateRandomPointInACircle(10,5,-7.5);
        System.out.println(Arrays.toString(obj.randPoint()));
        System.out.println(Arrays.toString(obj.randPoint()));
        System.out.println(Arrays.toString(obj.randPoint()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */