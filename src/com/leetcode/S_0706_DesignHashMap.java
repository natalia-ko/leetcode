package com.leetcode;
/*Design HashMap
Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions:
put(key, value) : Insert a (key, value) pair into the HashMap.
If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped,
or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)

Note:
All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.*/

public class S_0706_DesignHashMap {
    public static void main(String[] args) {

        S_0706_DesignHashMap m = new S_0706_DesignHashMap();
//        m.remove(14);
//        System.out.println(m.get(4));;
//        m.put(7, 3);
//        m.put(11, 1);
//        m.put(12, 1);
//        System.out.println(m.get(7));;
//        m.put(1, 19);
//        m.put(0, 3);
//        System.out.println(m.get(0));
//        m.put(1, 8);
//        m.put(2, 6);
//        m.put(11,0);
//        System.out.println(m.get(11));

        m.remove(2);
        m.put(3, 11);
        m.put(4, 13);
        m.put(1000000, 1000000);
        System.out.println(m.get(1000000));
        m.put(999999, 999999);
        System.out.println(m.get(999999));
        m.put(6, 15);
        m.put(8, 8);
        m.put(11, 0);
        System.out.println(m.get(11));
        m.put(1, 10);
        m.put(12, 14);
    }


    MapEntry[] entries;

    public S_0706_DesignHashMap() {
        entries = new MapEntry[1000001];
    }

    class MapEntry {
        int key;
        int value;

        public MapEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public void put(int key, int value) {
        entries[key] = new MapEntry(key, value);
    }


    public int get(int key) {
        if (entries[key] == null) {
            return -1;
        }
        return entries[key].value;
    }


    public void remove(int key) {
        if (entries[key] != null) {
            entries[key] = null;
        }
    }
}



