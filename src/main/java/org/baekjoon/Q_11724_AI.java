package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_11724_AI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        int connectedComponents = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(i, adjacencyList, visited);
            }
        }

        System.out.println(connectedComponents);
    }

    private static void dfs(int node, List<List<Integer>> adjacencyList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacencyList, visited);
            }
        }
    }
}
