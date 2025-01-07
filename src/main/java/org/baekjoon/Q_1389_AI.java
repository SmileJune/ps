package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS를 통해 각 노드 간의 거리를 계산하여 최소 합을 가진 노드의 인덱스를 찾는다.
 */
public class Q_1389_AI {

    static int N, M;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int minSum = Integer.MAX_VALUE;
        int resultNode = 0;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < minSum) {
                minSum = sum;
                resultNode = i;
            }
        }

        System.out.println(resultNode);
    }

    // BFS를 통해 시작 노드로부터 각 노드까지의 거리 합을 계산
    private static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        int totalDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            totalDistance += distance;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, distance + 1});
                }
            }
        }

        return totalDistance;
    }
}
