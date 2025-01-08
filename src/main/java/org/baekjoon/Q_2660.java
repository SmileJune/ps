package org.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2660 {

    static int N;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] scoreArr;
    static Queue<int[]> queue = new LinkedList<>();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        scoreArr = new int[N + 1];

        while(true) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(u == -1 && v == -1) {
                break;
            }

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            queue.offer(new int[]{i, 0});

            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int u = node[0];
                int step = node[1];

                scoreArr[i] = step;

                for (int v : list.get(u)) {
                    if (visited[v]) {
                        continue;
                    }

                    visited[v] = true;
                    queue.offer(new int[]{v, step + 1});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(min > scoreArr[i]) {
                min = scoreArr[i];
                list.clear();
                list.add(i);
            } else if(min == scoreArr[i]){
                list.add(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(min + " " + list.size());
        bw.newLine();
        for(int v : list) {
            bw.write(v + " ");
        }

        bw.close();
    }
}
