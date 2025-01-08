package org.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q_6118_AI {

    static int N, M, num, dist, cnt;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // BFS 초기화
        Queue<int[]> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(new int[]{1, 0}); // {노드 번호, 거리}

        num = 1; // 가장 작은 노드 번호
        dist = 0; // 거리
        cnt = 0; // 같은 거리 노드의 개수

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int current = node[0];
            int currentDist = node[1];

            if (dist < currentDist) {
                dist = currentDist;
                num = current;
                cnt = 1;
            } else if (dist == currentDist) {
                num = Math.min(num, current);
                cnt++;
            }

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, currentDist + 1});
                }
            }
        }

        System.out.println(num + " " + dist + " " + cnt);
    }
}
