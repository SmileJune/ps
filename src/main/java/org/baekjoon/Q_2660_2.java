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

public class Q_2660_2 {

    static int N;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] scoreArr;
    static int[][] map;
    static int INF = 100000;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        scoreArr = new int[N + 1];
        map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N ; j++) {
                if(i != j) {
                    map[i][j] = INF;
                }
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(u == -1 && v == -1) {
                break;
            }

            map[u][v] = 1;
            map[v][u] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int[] scores = new int[N + 1];
        int minScore = INF;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                scores[i] = Math.max(scores[i], map[i][j]);
            }
            minScore = Math.min(minScore, scores[i]);
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                result.append(i).append(" ");
                count++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(minScore + " " + count);
        bw.newLine();
        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
    }
}
