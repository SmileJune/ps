package org.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q_11403_AI {

    static int N;
    static int[][] map, answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = new int[N][N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                dfsInit(i);
                for (int j = 0; j < N; j++) {
                    answer[i][j] = visited[j] ? 1 : 0;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(answer[i][j] + " ");
                }
                bw.newLine();
            }
        }
    }

    static void dfsInit(int start) {
        // visited 배열 초기화 및 DFS 호출
        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }
        dfs(start);
    }

    static void dfs(int u) {
        visited[u] = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && map[u][i] == 1) {
                dfs(i);
            }
        }
    }
}
