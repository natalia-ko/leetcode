package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*Keys and Rooms
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
A key rooms[i][j] = v opens the room with number v.
Initially, all the rooms start locked (except for room 0).
You can walk back and forth between rooms freely.
Return true if and only if you can enter every room.
Example 1:
Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:
Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:
1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.*/
public class S_0841_KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(new LinkedList<Integer>() {{
            add(1);
//            add(3);
        }});
        rooms.add(new LinkedList<Integer>() {{
            add(2);
//            add(0);
//            add(1);
        }});
        rooms.add(new LinkedList<Integer>() {{
            add(3);
        }});
        rooms.add(new LinkedList<Integer>() {{
        }});

        System.out.println(canVisitAllRooms(rooms));

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        Stack<Integer> todo = new Stack<>();
        todo.push(0);

        while (!todo.isEmpty()) {
            int now = todo.pop();
            for (int i : rooms.get(now)) {
                if (!visited[i]) {
                    visited[i] = true;
                    todo.push(i);
                }
            }
        }

        for (boolean vis : visited) {
            if (!vis) {
                return false;
            }
        }
        return true;
    }
}
