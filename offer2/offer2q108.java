package offer2;

import java.util.*;


class Solution108 {
    //单向广度搜索
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);

        int length = 1;
        queue1.add(beginWord);

        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            if (word.equals(endWord)) {
                return length;
            }
            //1、生成邻居字符串
            List<String> neighbors = getNeighbors(word);
            //2、遍历查找邻居（是否在给定的字符串集合中，可能有多个）
            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisited.remove(neighbor);
                }
            }
            //3、若该层遍历完了，则距离+1，更新queue1为queue2
            if (queue1.isEmpty()) {
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (old != ch) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

    //双向广度优先搜索
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)) {
            return 0;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 2;
        set1.add(beginWord);
        set2.add(endWord);

        notVisited.remove(endWord);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            //1、比较大小，选择小的开始遍历
            if (set2.size() < set1.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            //2、创建下一层的set
            Set<String> set3 = new HashSet<>();
            //3、遍历set1中的节点
            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);
                //遍历set1中的节点的邻居节点
                for (String neighbor : neighbors) {
                    //4、终止条件
                    if (set2.contains(neighbor)) {
                        return length;
                    }
                    //5、如果没有终止，将在集合中的邻居节点添加到下一层，并在集合中删除
                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }
            //6、遍历set1结束，length+1
            length++;
            set1 = set3;
        }
        return 0;
    }
}