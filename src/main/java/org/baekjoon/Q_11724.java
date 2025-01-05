package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_11724 {

    static int N, M, answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i]) {
                continue;
            }

            answer++;
            dfs(i);
        }

        System.out.println(answer);
    }

    static void dfs(int u) {
        if(visited[u]) {
          return;
        }

        visited[u] = true;
        for(Integer v :list.get(u)) {
            dfs(v);
        }
    }
}
