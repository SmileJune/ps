package org.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Q_11403 {

    static int N;
    static int[][] map, answer;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    dfs(j);
                }
            }
            for(int j = 0; j < N; j++) {
                if (visited[j]) {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = 0;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }

    static void dfs(int u) {
        if(visited[u]) {
            return;
        }

        visited[u] = true;
        for(int i = 0; i < N; i++) {
            if(map[u][i] == 1) {
                dfs(i);
            }
        }
    }
}
